package sparkbase

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by zhoudunxiong on 2018/7/21.
  */
object TransformRDD {

  def main(args: Array[String]): Unit = {
    // RDD的转化操作是惰性求值
    // map、filter、flatMap
    // coalesce、repartition都是对RDD进行重新分区
    // coalesce使用的是HashPartitioner重新进行分区
    // repartition(8) = colaesce(8, shuffle = true)
    val conf = new SparkConf().setAppName("transform_rdd").setMaster("local[2]")
    val sc = new SparkContext(conf)
    val rdd1 = sc.textFile("build.sbt")
    println(s"par1 size: ${rdd1.partitions.size}")
    val rdd2 = rdd1.coalesce(1)
    println(s"par1 size: ${rdd2.partitions.size}")
    val rdd3 = rdd1.coalesce(4, true)
    println(s"par3 size: ${rdd3.partitions.size}")

    //假如在映射的过程中需要频繁的创建额外大的对象，mapPartition比map要好
    //mapPartition对每一个分区只进行一次操作

  }
}
