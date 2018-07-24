package sparkcore

/**
  * Created by zhoudunxiong on 2018/7/22.
  */
object SparkMessage {

  def main(args: Array[String]): Unit = {
    //spark 2.0使用的是Netty来是实现通信框架
    //spark 2.0之前使用的是Akka来实现通信框架
    //spark 启动的消息通信
    //spark 运行时的消息通信
    //sparkContext ---> master  ----> executor ----> sparkContext
    //sparkContext -- action --> DAG ---- DAGScheduler ----> stage ----> taskSet ---> TaskScheduler ---> executor
  }
}
