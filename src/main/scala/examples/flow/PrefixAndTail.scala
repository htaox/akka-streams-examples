package examples.flow

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.Source

/**
  * Created by aaron.nordyke on 5/23/17.
  */
object PrefixAndTail {

  def main(args: Array[String]): Unit = {
    implicit val system = ActorSystem("flow")
    implicit val materializer = ActorMaterializer()
    implicit val ec = system.dispatcher

    Source(1 to 10)
      .prefixAndTail(2)
      .runForeach(println)

  }
}

