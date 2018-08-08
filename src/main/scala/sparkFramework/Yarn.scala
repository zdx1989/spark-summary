package sparkFramework

/**
  * Created by zhoudunxiong on 2018/8/8.
  */
object Yarn {

  def main(args: Array[String]): Unit = {
    //YARN为一种统一资源管理器，在上面可以运行多套计算框架
    //除了spark还有mapReduce和storm
    //YARN也可以分为两种模式：YARN-client和YARN-cluster

    //YARN框架的组成：ResourceManager、NodeManager、ApplicationMaster、Container
    //RM：分配集群资源给各个应用
    //Container：资源分配调度的基本单位，其中封装了内存，cpu，磁盘和网络等资源
    //NM：一个个计算节点，负责启动应用需要的container，监控并上报资源给RM
    //AM：和具体的应用有关，负责同RM协商资源获取container，监控container的状态和进度

    //YARN-client的工作流
    //启动SparkContext，client向ResourceManager申请启动ApplicationMaster
    //ResourceManager收到请求，选择一个NodeManager，为该应用分配一个Container
    //在container中启动ApplicationMaster，在client模式中sparkContext运行在client中
    //ApplicationMater不运行SparkContext，只和它联系并进行资源分派
    //sparkContext启动完毕，和ApplicationMaster简历通信，向ResourceManager注册并申请Container
    //ApplicationMaster申请到资源后，启动container并向sparkContext注册和申请任务集
    //任务执行完后，sparkContext向ResourceMaster申请注销并关闭自身

    //YARN-cluster的工作步骤
    //spark的driver作为一个applicationMaster在YARN集群中启动
    //ApplicationMaster中创建应用程序，它向resourceManger申请资源，启动executor来运行任务集
    //监控应用的整个过程，知道完成运行

    //

  }
}
