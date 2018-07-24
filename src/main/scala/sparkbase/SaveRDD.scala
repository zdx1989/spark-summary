package sparkbase

import org.apache.hadoop.io.{IntWritable, Text}
import org.apache.hadoop.mapred.TextOutputFormat
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by zhoudunxiong on 2018/7/22.
  */
object SaveRDD {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("save_rdd").setMaster("local[2]")
    val sc = new SparkContext(conf)
    //saveAsTextFile(path: String) saveAsTextFile(path: String, codec) 存储文本 codec指定压缩格式
    //saveAsSequenceFile(path: String, codec: Option) 存储SequenceFile codec问压缩格式
    //saveAsObjectFile 对象序列化存储到文件中，对于HDFS默认是SequenceFile保存
    val rdd = sc.parallelize(1 to 10, 2)
    println(s"par size: ${rdd.partitions.size}")
    //目录存在的话抛出目录已经存在的异常
    rdd.saveAsTextFile("hdfs://localhost:9000/chap3/textfile1")
    val rdd1 = sc.parallelize(1 to 10, 4)
    println(s"par size: ${rdd1.partitions.size}")
    rdd1.saveAsObjectFile("hdfs://localhost:9000/chap3/textfile2")
    //保存的文件数和partition有关，4个partition 对应 4个task 保存的时候生成4分文件
    //-rw-r--r--   3 zhoudunxiong supergroup          0 2018-07-22 13:04 /chap3/textfile2/_SUCCESS
    //-rw-r--r--   3 zhoudunxiong supergroup        142 2018-07-22 13:04 /chap3/textfile2/part-00000
    //-rw-r--r--   3 zhoudunxiong supergroup        146 2018-07-22 13:04 /chap3/textfile2/part-00001
    //-rw-r--r--   3 zhoudunxiong supergroup        142 2018-07-22 13:04 /chap3/textfile2/part-00002
    //-rw-r--r--   3 zhoudunxiong supergroup        146 2018-07-22 13:04 /chap3/textfile2/part-00003

    //saveAsHadoopFile
    val rdd2 = sc.parallelize(Array(("zdx", 29), ("ygy", 18)))
    rdd2.saveAsHadoopFile(
      "hdfs://localhost:9000/chap3/hadoopfile",
      classOf[Text],
      classOf[IntWritable],
      classOf[TextOutputFormat[Text, IntWritable]])

    //saveAsHadoopDataSet可以将rdd保存在除HDFS之外其它的存储中，例如Hbase
  }
}
