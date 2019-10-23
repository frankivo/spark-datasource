package nl.frankivo.spark

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.sources.{BaseRelation, Filter, PrunedFilteredScan}
import org.apache.spark.sql.types.StructType
import org.apache.spark.sql.{Row, SQLContext}
import org.apache.spark.{Partition, TaskContext}

class FrankivoRelation(_sqlContext: SQLContext, _schema: StructType) extends BaseRelation with PrunedFilteredScan {
  override def sqlContext: SQLContext = _sqlContext

  override def schema: StructType = _schema

  override def buildScan(requiredColumns: Array[String], filters: Array[Filter]): RDD[Row] =
    new RDD[Row](sqlContext.sparkContext, Nil) {
      override def compute(split: Partition, context: TaskContext): Iterator[Row] = ???

      override protected def getPartitions: Array[Partition] = Array.empty
    }

  override def toString: String = FrankivoRelationProvider.SHORT_NAME
}
