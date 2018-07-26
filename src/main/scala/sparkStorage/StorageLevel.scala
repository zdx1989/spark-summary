package sparkStorage

/**
  * Created by zhoudunxiong on 2018/7/27.
  */
object StorageLevel {

  def main(args: Array[String]): Unit = {
    //RDD的数据集可以缓存在内存或者硬盘中，persist和cache
    //def persist(newLevel: StorageLevel, allowOverride: Boolean)
    //假如level不为None时，存储级别不可以被覆盖修改

    //cache() === persist(MEMORY_ONLY)
    //StorageLevel, useDisk, useMemory, useHeap, Seralized, relication
    //五个参数控制12个存储级别, 常见的如下
    //MEMORY_ONLY
    //MEMORY_AND_DISK
    //MEMORY_SER
    //MEMORY_SER_2

    //RDD--> partition ---> Block ----> BlockID
    //Persist 并没有发生数据存储，实际发生储存的是任务运行阶段
  }
}
