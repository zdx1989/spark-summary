package sparkStorage

/**
  * Created by zhoudunxiong on 2018/7/26.
  */
object StorageFramework {

  def main(args: Array[String]): Unit = {
    //driver(blockManagerMater) -----> executor(blockManager)
    //driver sparkContext创建SparkEnv, sparkEnv实例化BlockManagerMaster, 在创建消息通信终点BlockManagerMasterEndPoint
    //Driver: SparkContext ---> SparkEnv ---> BlockManagerMaster ---> BlockManagerMasterEndPoint
    //Executor: SparkEnv实例化BlockManager和网络数据传输服务BlockTransferService
    //Executor: SparkEnv ---> BlockManager ---> BlockManagerSlaveEndPoint  ---> 和Driver进行消息传输
    //Executor: SparkEnv ---> BlockTransferService ---> 网络数据的传输
    //Executor有BlockManagerMasterEndPoint的引用；driver有blockManagerSlaveEndPoint的引用
    //相互持有终端点的引用，方便程序执行的过程中进行消息通信

    //BlockManagerMasterEndPoint保存了3个HashMap的元数据：
    // BlockManagerId -> BlockManagerInfo, ExecutorId -> BlockManagerId, BlockId -> BlockManagerId
  }
}
