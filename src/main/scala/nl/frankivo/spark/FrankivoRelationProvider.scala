package nl.frankivo.spark

import org.apache.spark.sql.sources.DataSourceRegister

class FrankivoRelationProvider extends DataSourceRegister {
  override def shortName(): String = "frankivo"
}
