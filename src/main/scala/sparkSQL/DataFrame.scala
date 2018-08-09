package sparkSQL

/**
  * Created by zhoudunxiong on 2018/8/9.
  */
class DataFrame {

  def main(args: Array[String]): Unit = {
    //DataFrame是以RDD为基础的分布式数据集，类似于传统数据库中的二维表格
    //DF和RDD的区别是，DF带有scheme元数据，即DF表示的二维数据集中每一列都带有字段名和字段类型
    //sparkSQL查询优化器可以根据scheme元数据进行针对性的优化
    //DataFrame的优点
    //减少代码量
    //提升执行效率
    //减少数据的读取：sparkSQL可以利用RCFile、ORC、Parquet等列式存储格式的优势，仅扫描真正需要的列，忽略其它的列
    //sparkSQL执行原理
    //词法和语法分析（parse），对输入的SQL进行词法和语法分析形成逻辑计算
    //绑定 将SQL语句和数据字典进行绑定，确定SQL语句可以执行
    //优化，在多个执行计划中选择一个最优的执行计划
    //执行：获取执行计划，从数据库中查询出数据
  }
}
