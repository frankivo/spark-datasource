package nl.frankivo.spark

import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.sources.{BaseRelation, DataSourceRegister, SchemaRelationProvider}
import org.apache.spark.sql.types.StructType

class FrankivoRelationProvider extends DataSourceRegister with SchemaRelationProvider {
  override def shortName(): String = "frankivo"

  override def createRelation(sqlContext: SQLContext, parameters: Map[String, String], schema: StructType): BaseRelation = ???
}
