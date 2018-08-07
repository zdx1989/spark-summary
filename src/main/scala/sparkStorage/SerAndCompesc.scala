package sparkStorage

/**
  * Created by zhoudunxiong on 2018/8/2.
  */
object SerAndCompesc {

  def main(args: Array[String]): Unit = {
    //spark中内置了两个序列化类JavaSerializer和KryoSerializer
    //默认的情况下spark使用javaSerializer，它使用的是java的ObjectOutputStream序列化框架，灵活但是性能不佳
    //KryoSerializer压缩的效率更高，不过它不支持用户所有的系列化对象，需要注册类

    //spark提供了三种压缩方法，LZ4（压缩比和压缩速度俱佳）默认、LZF（更高压缩比）、Snappy（更快压缩速度） <- CompressionCode
  }
}
