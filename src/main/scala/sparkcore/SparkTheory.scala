package sparkcore

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by zhoudunxiong on 2018/7/22.
  */
object SparkTheory {

  def main(args: Array[String]): Unit = {
    //job 由action算子触发产生的一个或者多个调度阶段
    //stage 由依赖关系将DAG拆分成多个任务集合（taskSet），DAGScheduler来划分划分成ShuffleMapStage和ResultStage
    //task 在executor上运行的工作任务，是Spark执行应用的最小单位
    //DAGScheduler 面向stage的调度器，根据RDD的依赖关系划分stage， 并提交TaskSet给TaskScheduler
    //TaskScheduler 面向任务的调度器，分发task到work节点的executor进程去执行

    //DAGScheduler 记录rdd被存入磁盘的物化操作，寻求任务的最优调度，例如数据的本地行
    //TaskScheduler 负责任务失败的时候的任务的重试，任务运行一直未完成的时候，TS会重新启动一个一样的Task，谁先跑完用谁的结果

    //worker中的executor进程收到TS发来的任务集之后，已多线程的方式运行，一个线程负责一个任务，任务的并行数由spark-executor-core来决定

    //wordCount
    val conf = new SparkConf().setAppName("spark_theory").setMaster("local[2]")
    val sc = new SparkContext(conf)
    val lines = sc.textFile("hdfs://localhost:9000/user/zhoudunxiong/README.txt")
    val wordCount = lines.flatMap(_.split(" ")).map(x => (x, 1)).reduceByKey(_ + _).count()
    println(s"count: $wordCount")
    //count 触发sparkcontext的runJob的提交作业
    //def count(): Long = sc.runJob(this, Utils.getIteratorSize _).sum

    //rdd ---依赖关系---> DAG ---DAGScheduler---> runJob
    //sparkContext.runJob ----> DAgScheduler.runJob

    //application划分成多个job，job之间的调度spark提供了两种策略一个是FIFO默认模式，一个是FAIR模式

    //
  }
}
