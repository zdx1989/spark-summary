package sparkStorage

/**
  * Created by zhoudunxiong on 2018/7/31.
  */
object SparkShuffle {

  def main(args: Array[String]): Unit = {
    //把分布在不同节点的数据按照一定的规则聚集在一起的过程称为Shuffle
    //shuffle存在的问题：
    //涉及磁盘的读写和网络的传输，shuffle性能的高低严重影响程序的性能和吞吐量

    //shuffle写操作
    //基于哈希的Shuffle写操作
    //mapper会根据reduce的数量创建相应的bucket，bucket的个数为M * R
    //Mapper生成的结果会根绝partition的算法填充到每个bucket中
    //bucket是一个抽象的概念，在该机制中对应着一个文件
    //Reduce启动的时候会根据依赖的mapper编号从远端或者本地取相应的bucket最为reduced的输入
    //通过shuffleDependency定义了aggregator判断是否需要在map端进行预聚合

    //基于排序的Shuffle写操作
    //基于哈希的Shuffle有下面这些问题
    //一次shuffle会产生M * R个文件，数据量不大，文件又多的情况下，随机写会严重降低I/O性能
    //硬盘写文件的时候，缓存的消耗也是非常大的

    //基于排序的shuffle， Map task不会为每个Reducer单独创建一个文件，而是将所有的结果写到一个文件中
    //对应生成一个index文件进行索引
    //在硬盘中排序，避免内存占用太多
    //同样可以在Map端进行预聚合

    //shuffle写操作
    //如何确认数据读取的位置信息？包括数据所在节点，executor的编号，blockid
    //需要从driver获取上有shuffle结果的位置信息
    //如果数据在本地blockManger负责读取， 如果在远端通过netty获取，远端读取采用多线程的方式读取
    //每次请求的数据量通过spark.reducer.maxSizeInFight配置项进行配置
    //判断是否需要预聚合，聚合完进行外部排序
    //
  }
}
