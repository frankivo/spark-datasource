package nl.frankivo.spark

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.sources.{BaseRelation, Filter, PrunedFilteredScan}
import org.apache.spark.sql.types.StructType
import org.apache.spark.sql.{Row, SQLContext}

class FrankivoRelation(_sqlContext: SQLContext, _schema: StructType) extends BaseRelation with PrunedFilteredScan {
  override def sqlContext: SQLContext = _sqlContext

  override def schema: StructType = _schema

  override def buildScan(requiredColumns: Array[String], filters: Array[Filter]): RDD[Row] =
    new FrankivoRDD[Row](_sqlContext.sparkContext)

  override def toString: String = FrankivoRelationProvider.SHORT_NAME
}
