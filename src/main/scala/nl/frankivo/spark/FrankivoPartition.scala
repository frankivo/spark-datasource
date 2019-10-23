package nl.frankivo.spark

import org.apache.spark.Partition

class FrankivoPartition extends Partition {
  override def index: Int = 0
}
