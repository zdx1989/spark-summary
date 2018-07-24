package sparkcore

/**
  * Created by zhoudunxiong on 2018/7/22.
  */
object sparkBase {

  def main(args: Array[String]): Unit = {
    //Application spark应用，包含一个driver节点上的代码和分布在集群多个节点的executor代码
    //Driver 运行Application中的Main函数，创建SparkContext，SparkContext准备运行环境，负责和
       //和clusterManager通信，进行资源的申请、任务分发和监控；executor运行完毕，driver负责关闭sparkcontext
    //cluster Manager集群资源管理器，standalone、spark on yarn、 spark on mesos
    //master(resource manager)分配管理和分配集群资源， worker(node manager)远行application中的代码
    //executor 执行进程，运行在worker节点上，该进程负责运行task和缓存数据到内存和硬盘，每个app有独立的executor
    /
  }
}
