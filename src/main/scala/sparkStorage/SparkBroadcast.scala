package sparkStorage

/**
  * Created by zhoudunxiong on 2018/8/7.
  */
object SparkBroadcast {

  def main(args: Array[String]): Unit = {
    //广播变量可以在集群每个节点都缓存一份变量，避免在各个任务节点见传递变量，利用广播变量可以高效的分发变量副本
    //累加器，能够有效的支持并行计算，在各个task中累加求和
  }
}
