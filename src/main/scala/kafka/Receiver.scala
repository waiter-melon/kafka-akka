package kafka

import akka.actor.Actor
import cakesolutions.kafka.akka.{ConsumerRecords, Extractor}
import cakesolutions.kafka.akka.KafkaConsumerActor.Confirm

class Receiver extends Actor {

  val recordsExt: Extractor[Any, ConsumerRecords[String, String]] = ConsumerRecords.extractor[String, String]

  override def receive: Receive = {
    case recordsExt(records) =>
      processRecords(records.pairs)
      sender() ! Confirm(records.offsets)
  }

  def processRecords(records: Seq[(Option[String], String)]): Unit = {
    records.foreach(rec => println(rec._1.getOrElse("-") + " | " + rec._2))
  }
}
