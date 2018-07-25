package sparkcore

/**
  * Created by zhoudunxiong on 2018/7/25.
  */
object SparkTask {

  def main(args: Array[String]): Unit = {

    //DAGScheduler根据partitions的个数拆分成对应个数的task，这些任务组成taskSet提交给TaskScheduler
    //ShuffleMapStage -> ShuffleMapTask; ResultStage -> ResultTask
    //TaskSet中所有的任务处理逻辑是一样的，不同的是对应的数据不同，这些数据是其对应的分片partition
    //Task的资源分配，根据数据本地性的原则，为Task分配合适的worker节点
    //数据本地性的优先级原则是Process_local, Node_Local, No_Pref, Rack_local, Any

    //对于ShuffleMapTask执行结果会写到BlockManager中，返回给DAGScheduler是一个MapStatus的对象
    //对于ResultTask返回的是最终func执行的结果
  }
}
