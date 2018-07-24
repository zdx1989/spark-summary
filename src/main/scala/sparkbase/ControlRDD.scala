package sparkbase

import org.apache.spark.storage.StorageLevel
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by zhoudunxiong on 2018/7/21.
  */
object ControlRDD {

  def main(args: Array[String]): Unit = {
    //rdd持久化可以提高迭代计算的效率以及在计算模型之间共享数据
    //一般executor的内存有60%用于缓存数据，40%用于任务运算
    //spark使用cache和persist
    val conf = new SparkConf().setAppName("control_rdd").setMaster("local[2]")
    val sc = new SparkContext(conf)
    val sogou = sc.textFile("hdfs://localhost:9000/sogou/access_log.20060801.decode.filter")
    sogou.cache()
    println(s"count1: ${sogou.count()}")
    println(s"count2: ${sogou.count()}")
    println(s"par size: ${sogou.partitions.size}")
    sogou.take(10).foreach(println)

    //cache() = persist(MEMORY_ONLY)
    //同一个RDD不能重复缓存
    val sogou1 = sc.textFile("hdfs://localhost:9000/sogou/access_log.20060802.decode.filter")
    sogou1.persist(StorageLevel.DISK_ONLY)
    println(s"count3: ${sogou1.count()}")
    println(s"count4: ${sogou1.count()}")

    //设置检查点checkpoint对宽依赖RDD的恢复容错非常有用
    val rdd = sc.makeRDD(1 to 4, 1)
    val flatMapRdd = rdd.flatMap(x => Seq(x, x))
    sc.setCheckpointDir(s"hdfs://localhost:9000/checkpoint/")
    flatMapRdd.checkpoint()
    println(s"dep rdd: ${flatMapRdd.dependencies.head.rdd}")
    flatMapRdd.collect()
    println(s"dep rdd: ${flatMapRdd.dependencies.head.rdd}")
    //Thread.sleep(3 * 60 * 1000)
    sc.stop()
  }
}
