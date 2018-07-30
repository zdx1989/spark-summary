package sparkStorage

/**
  * Created by zhoudunxiong on 2018/7/30.
  */
object WriteData {

  def main(args: Array[String]): Unit = {
    //speak写入数据同样分为写入内存和写入硬盘
    //写入数据主要调用BlockManager的putIterator

    //写入内存, 假如序列化了说明获取的数据为值类型，没有序列化获取的数据为字节类型
    //内存太小的化， 数据会溢写到硬盘
    //写入数据完成的时候，需要把数据块的元数据发给driver
    //内存的写入分为MemoryStore asValue存储值类型，asBytes存储字节类型

    //写入硬盘 DiskStore put
  }
}
