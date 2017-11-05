package kafka

import akka.actor.{Actor, Props}
import cakesolutions.kafka.akka.KafkaConsumerActor
import cakesolutions.kafka.akka.KafkaConsumerActor.Subscribe
import com.typesafe.config.ConfigFactory
import org.apache.kafka.common.serialization.StringDeserializer

object BootNow

class KafkaBoot extends Actor {

  override def receive: Receive = {
    case BootNow =>
      val receiver = context.actorOf(Props[Receiver], "message-receiver")
      val conf = ConfigFactory.load("consumer.conf")
      val consumerProps = KafkaConsumerActor.props(conf, new StringDeserializer(), new StringDeserializer(), receiver)
      val consumer = context.actorOf(consumerProps)

      consumer ! Subscribe.AutoPartition(Seq("first_topic"))
  }

}
