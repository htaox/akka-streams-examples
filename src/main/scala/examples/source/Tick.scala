package examples.source

import akka.NotUsed
import akka.actor.{ActorSystem, Cancellable}
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.Source

import scala.concurrent.duration._

/**
  * Created by aaron.nordyke on 5/23/17.
  */
object Tick {

  def main(args: Array[String]): Unit = {
    implicit val system = ActorSystem("source")
    implicit val materializer = ActorMaterializer()

    val source: Source[Int, Cancellable] = Source.tick(0.seconds, 1.seconds, 1)
    source.runForeach(println)
  }
}
