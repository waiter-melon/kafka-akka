package kafka

import akka.actor._

object Boot extends App {

    val context = ActorSystem("kafka")

    val kafkaBoot = context.actorOf(Props[KafkaBoot], "boot")

    kafkaBoot ! BootNow

    while (true) {

    }

}
