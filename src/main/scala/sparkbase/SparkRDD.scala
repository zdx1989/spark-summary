package sparkbase

import org.apache.spark.{HashPartitioner, SparkConf, SparkContext}

/**
  * Created by zhoudunxiong on 2018/7/21.
  */
object SparkRDD {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("spark_rdd").setMaster("local[2]")
    val sc = new SparkContext(conf)
    //默认读取的rdd的partition个数和cpu的核数一样
    val part = sc.textFile("build.sbt")
    val partitions = part.partitions.size
    println(s"partitions: $partitions")
    //读取rdd的时候可以指定partition的个数
    val part1 = sc.textFile("build.sbt", 6)
    val partititons1 = part1.partitions.size
    println(s"partitions1: $partititons1")

    val rdd = sc.textFile("build.sbt")
    val wordMap = rdd.flatMap(_.split(" ")).map(x => (x, 1))
    //窄依赖：父rdd的分区至多只被子rdd的一个分区依赖
    wordMap.dependencies.foreach { dep =>
      println(s"dep class: ${dep.getClass}")
      println(s"dep rdd: ${dep.rdd}")
      println(s"dep par: ${dep.rdd.partitions}")
      println(s"dep par size: ${dep.rdd.partitions.size}")
    }
    val wordReduce = wordMap.reduceByKey(_ + _)
    //宽依赖：父rdd的分区被多个子rdd的分区依赖
    wordReduce.dependencies.foreach { dep =>
      println(s"dep class: ${dep.getClass}")
      println(s"dep rdd: ${dep.rdd}")
      println(s"dep par: ${dep.rdd.partitions}")
      println(s"dep par size: ${dep.rdd.partitions.size}")
    }

    //分区计算mapPartitions输入函数应该应用于每个分区，每个分区作为整体来处理
    val a = sc.parallelize(1 to 9, 3)
    def iterFunc[A](iter: Iterator[A]): Iterator[(A, A)] = {
      var res = List[(A, A)]()
      var pre = iter.next()
      while (iter.hasNext) {
        val cur = iter.next()
        res = (pre, cur) :: res
        pre = cur
      }
      res.iterator
    }
    val b = a.mapPartitions(iterFunc).collect().toList
    println(s"b: $b")

    //分区器（partitioner），分区器存在与（K，V）类型的RDD中一般的RDD中的值为None
    //spark默认提供两种分区器：哈希分区器（HashPartitioner）和范围分区器（RangePartitioner）
    //分区划分决定了rdd之间的依赖关系
    //非（K， V）型rdd的partitioner为None
    val part2 = sc.textFile("build.sbt")
    println(s"partitioner1: " + part2.partitioner)
    //用户可以自定义分区器（可指定分区个数），默认的是HashPartitoner，
    //其中的分区数个数由spark.default.parallelism配置，没配置的话是rdd本身的分区个数取最大值
    val groupRdd = part2.map(x => (x, x)).groupByKey(new HashPartitioner(4))
    println(s"partitioner2: " + groupRdd.partitioner)
  }
}
