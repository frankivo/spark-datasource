package nl.frankivo.spark

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{LongType, StringType, StructType}

object FrankivoDataSourceTest extends App {

  val spark = SparkSession
    .builder
    .appName("MyDataSourceTest")
    .master("local[*]")
    .getOrCreate

  val schema = new StructType()
    .add("id", LongType)
    .add("name", StringType)

  val df = spark
    .read
    .format("frankivo")
    .schema(schema)
    .load

  df.show
}
