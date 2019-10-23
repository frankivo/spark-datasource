package nl.frankivo.spark

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.Row
import org.apache.spark.{Partition, SparkContext, TaskContext}

class FrankivoRDD(sparkContext: SparkContext) extends RDD[Row](sparkContext, Nil) {

  override def compute(split: Partition, context: TaskContext): Iterator[Row] = Iterator(
    Row(1L, "Row 1"),
    Row(2L, "Row 2")
  )

  override protected def getPartitions: Array[Partition] = Array(
    new FrankivoPartition
  )
}
