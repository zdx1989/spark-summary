package sparkbase

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by zhoudunxiong on 2018/7/22.
  */
object ActionRDD {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("action_rdd").setMaster("local[2]")
    val sc = new SparkContext(conf)
    //行动（action）操作会触发转化操作的执行，并生成对应的job
    val rdd = sc.parallelize(1 to 10, 4)
    println(s"rdd fir: ${rdd.first()}")
  }
}
