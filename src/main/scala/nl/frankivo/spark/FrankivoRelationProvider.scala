package nl.frankivo.spark

import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.sources._
import org.apache.spark.sql.types.StructType

class FrankivoRelationProvider extends DataSourceRegister with SchemaRelationProvider {
  override def shortName(): String = FrankivoRelationProvider.SHORT_NAME

  override def createRelation(
                               sqlContext: SQLContext,
                               parameters: Map[String, String],
                               schema: StructType
                             ): BaseRelation = new FrankivoRelation(sqlContext, schema)
}

object FrankivoRelationProvider {
  val SHORT_NAME = "frankivo"
}