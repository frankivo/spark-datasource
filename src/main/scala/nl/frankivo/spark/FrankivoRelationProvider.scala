package nl.frankivo.spark

import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.sources.{BaseRelation, DataSourceRegister, SchemaRelationProvider}
import org.apache.spark.sql.types.StructType

class FrankivoRelationProvider extends DataSourceRegister with SchemaRelationProvider {
  override def shortName(): String = "frankivo"

  override def createRelation(
                               sqlContext: SQLContext,
                               parameters: Map[String, String],
                               _schema: StructType
                             ): BaseRelation = {
    new BaseRelation {
      override def sqlContext: SQLContext = ???

      override def schema: StructType = _schema
    }
  }
}
