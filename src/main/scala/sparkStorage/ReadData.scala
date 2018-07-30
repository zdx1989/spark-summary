package sparkStorage

/**
  * Created by zhoudunxiong on 2018/7/29.
  */
object ReadData {

  def main(args: Array[String]): Unit = {
    //blockManager的get方法是读取数据的入口
    //在读取时分为本地读取（getLocalValues）和远程读取（getRemoteValues）
    //本地读取时根据存储级别，分内存读取和硬盘读取

    // 内存又分为值读取（getValues）和数据流读取（getBytes）
    // 内存中获取数据最终都是通过blockID去获取数据
    //spark的内存存储其实是一个很大的LinkHashMap： blockID -> blockData

    //硬盘读取调用的是DiskStore的getBytes方法，读取后缓存在内存
    //spark.local.dir 设置磁盘存储的以及目录
    //RandomAccessFile只读方式打开文件

    //远程节点读取方式, spark2.0提供Netty远程读取方式
    //NettyBlockTransferService -> Netty RPC -> Shuffle 存储模块提供储存数据接口
    //getRemoteBytes -> fetch block

  }
}
