package sparkcore

/**
  * Created by zhoudunxiong on 2018/7/25.
  */
object SparkHA {

  def main(args: Array[String]): Unit = {
    // Worker异常， worker会发送心跳给master，上报worker的实时状态，master也会实时感知worker是否超时
    //Master异常，active master和standby master
    //spark-env.sh 配置项spark.deploy.recoverMode， 默认为None
    //可以配置为zookeeper，filesystem，custom，None


  }
}
