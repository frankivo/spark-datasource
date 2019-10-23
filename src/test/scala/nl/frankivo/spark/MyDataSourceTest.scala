package nl.frankivo.spark

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.StructType

object MyDataSourceTest extends App{

  val spark = SparkSession
    .builder
    .appName("MyDataSourceTest")
    .master("local[*]")
    .getOrCreate

  val schema = new StructType()
  spark
    .read
    .format("frankivo")
    .schema(schema)
    .load
    .explain
}
