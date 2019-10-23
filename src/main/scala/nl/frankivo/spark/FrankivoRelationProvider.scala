package nl.frankivo.spark

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.sources._
import org.apache.spark.sql.types.StructType
import org.apache.spark.sql.{Row, SQLContext}
import org.apache.spark.{Partition, TaskContext}

class FrankivoRelationProvider extends DataSourceRegister with SchemaRelationProvider {
  override def shortName(): String = FrankivoRelationProvider.SHORT_NAME

  override def createRelation(
                               _sqlContext: SQLContext,
                               _parameters: Map[String, String],
                               _schema: StructType
                             ): BaseRelation = {
    new BaseRelation with PrunedFilteredScan {
      override def sqlContext: SQLContext = _sqlContext

      override def schema: StructType = _schema

      override def buildScan(requiredColumns: Array[String], filters: Array[Filter]): RDD[Row] =
        new RDD[Row](sqlContext.sparkContext, Nil) {
          override def compute(split: Partition, context: TaskContext): Iterator[Row] = ???

          override protected def getPartitions: Array[Partition] = ???
        }

      override def toString: String = FrankivoRelationProvider.SHORT_NAME
    }
  }
}

object FrankivoRelationProvider {
  val SHORT_NAME = "frankivo"
}