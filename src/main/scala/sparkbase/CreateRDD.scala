package sparkbase

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by zhoudunxiong on 2018/7/21.
  */
object CreateRDD {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("create_rdd").setMaster("local[2]")
    val sc = new SparkContext(conf)
    //创建rdd的两种方式：1 并行化集合sc.parallelize(List)
    //2 从外部存储读取rdd sc.textFile(path)
    val rdd = sc.parallelize(1 to 10)
    println(s"rdd: ${rdd.collect().toList}")
    println(s"par size: ${rdd.partitions.size}")
    // 显示的设置分区
    val rdd1 = sc.parallelize(1 to 10, 4)
    println(s"rdd: ${rdd1.collect().toList}")
    println(s"par size: ${rdd1.partitions.size}")
    //使用makeRDD创建RDD，还可以指定Rdd的首先位置
    val collect = Seq((1 to 5, Seq("local")), (6 to 10, Seq("local")))
    val rdd2 = sc.makeRDD(collect)
    println(s"par size ${rdd2.partitions.size}")
    println(s"pre loc: ${rdd2.preferredLocations(rdd2.partitions(0))}")
    println(s"pre loc: ${rdd2.preferredLocations(rdd2.partitions(1))}")

    //spark读取外部存储系统支持的数据源：本地文件系统（每个work节点都的有）
    //HDFS、HBase、S3、Cassandra
    //支持的格式textFile、SequenceFile、HadoopInputFormat
    val rdd3 = sc.textFile("build.sbt")
    println(s"count: ${rdd3.count()}")
    println(s"par size: ${rdd3.partitions.size}")
    //
    val rdd4 = sc.textFile("hdfs://localhost:9000/user/zhoudunxiong/README.txt", 7)
    println(s"count: ${rdd4.count()}")
    println(s"par size: ${rdd4.partitions.size}")
  }
}
