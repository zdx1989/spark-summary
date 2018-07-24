
import org.apache.spark.{HashPartitioner, Partitioner, SparkConf, SparkContext}

/**
  * Created by zhoudunxiong on 2018/7/11.
  */
object WordCount {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[2]").setAppName("word_count")
    val sc = new SparkContext(conf)
    val lines = sc.textFile("hdfs://localhost:9000/user/zhoudunxiong/README.txt")
    println(s"partitions size: ${lines.getNumPartitions}")
    val words = lines.flatMap(_.split(" "))
    val ones = words.map(w => (w, 1))
                    .partitionBy(new HashPartitioner(8)).persist()
    println(s"ones partitions sizes: ${ones.getNumPartitions}")
    val counts = ones.reduceByKey(_ + _)
    counts.partitions.foreach(p => {
      println(counts.preferredLocations(p))
    })
    counts.collect().foreach(println)
    Thread.sleep(3 * 60 * 1000)
  }
}

case class FirstPartitioner(numPartition: Int) extends Partitioner {

  override def numPartitions: Int = numPartition

  override def getPartition(key: Any): Int = {
    val first = key.toString.head
    val code = first.hashCode % numPartition
    if (code < 0)
      code + numPartition
    else
      code
  }

  override def equals(obj: Any): Boolean = obj match {
    case FirstPartitioner(numP) => numP == numPartition
    case _ => false
  }
}
