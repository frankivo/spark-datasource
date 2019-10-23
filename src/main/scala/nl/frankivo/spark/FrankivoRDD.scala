package nl.frankivo.spark

import org.apache.spark.rdd.RDD
import org.apache.spark.{Partition, SparkContext, TaskContext}

class FrankivoRDD[T](sparkContext: SparkContext) extends RDD[T](sparkContext, Nil) {

  override def compute(split: Partition, context: TaskContext): Iterator[T] = ???

  override protected def getPartitions: Array[Partition] = Array.empty
}
