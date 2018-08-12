package sparkSQL

/**
  * Created by zhoudunxiong on 2018/8/12.
  */
object HiveContext {

  def main(args: Array[String]): Unit = {
    //HiveContext继承于SQLContext，对Hive数据进行访问
    //HiveContext的运行过程

    //使用HqlParse生成未绑定的逻辑计划，使用Antlr进行词法和语法解析
    //使用Analyzer绑定逻辑计划，analyzer解析器结合Hive元数据metedata进行绑定，生成绑定的逻辑计划
    //使用Optimizer优化逻辑计划
    //使用SparkPlanner生成可执行的物理计划
    //使用QueryExecution执行物理计划

    //
  }
}
