package sparkSQL

/**
  * Created by zhoudunxiong on 2018/8/9.
  */
object SQLFramework {

  def main(args: Array[String]): Unit = {
    //spark SQL主要由Core、Catalyst、Hive、Hive-thriftServer组成
    //core: 负责处理数据的输入和输出，从不同的数据源中获取数据，将查询结果输出为dataFrame
    //catalyst:负责整个查询语句处理过程，包括解析、绑定、优化、物理执行计划
    //hive：对hive的数据进行处理
    //hive-thriftServe：提供CLI和JDBC／ODBC的接口


  }

}
