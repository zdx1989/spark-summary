package sparkcore

/**
  * Created by zhoudunxiong on 2018/7/24.
  */
object SparkStage {

  def main(args: Array[String]): Unit = {
    //stage的划分由DAGScheduler实现，它从最后一个RDD广度优先遍历整个依赖树，遇到shuffleDependence（宽依赖）即切分成前后两个阶段
    //Stage划分为ShuffleMapStage和ResultStage
    //Stage划分完毕之后，Stage之间确立依赖关系

//    private[scheduler] abstract class Stage(
//     val id: Int,
//     val rdd: RDD[_],
//     val numTasks: Int,
//     val parents: List[Stage],
//     val firstJobId: Int,
//     val callSite: CallSite)

    //每一个Stage都有一个parents属性，通过该属性可以确定当前Stage的祖先Stage，可以按照这些信息顺序的提交调度Stage进行运行
    //切分Stage：DAGScheduler根据shuffleDependence将DAG划分成不同的Stage，诀窍：从最后的RDD开始遇到shuffle就把血缘链切开
    //提交Stage：根据Stage的依赖关系，顺序提交Stage
  }
}
