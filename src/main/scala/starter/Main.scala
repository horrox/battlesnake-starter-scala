package starter

import cats.effect.IO
import com.twitter.finagle.{Http, Service}
import com.twitter.finagle.http.{Request, Response}
import com.twitter.util.Await
import io.finch._
import io.finch.catsEffect._
import io.finch.circe._
import io.circe.generic.auto._

import scala.util.Properties

object Main extends App {

  def info: Endpoint[IO, ServerInfo] =
    get(pathEmpty) {
      Ok(ServerInfo("1", "horrox", "#ff1500", "bendr", "curled"))
    }

  def start: Endpoint[IO, Unit] =
    post("start" :: jsonBody[GameState]) { (gameState: GameState) =>
      Ok()
    }

  def move: Endpoint[IO, Move] =
    post("move" :: jsonBody[GameState]) { (gameState: GameState) =>
      Ok(Move("up", "Shout out!"))
    }

  def end: Endpoint[IO, Unit] =
    post("end" :: jsonBody[GameState]) { (gameState: GameState) =>
      Ok()
    }

  def service: Service[Request, Response] =
    Bootstrap
      .serve[Application.Json](info :+: start :+: move :+: end)
      .toService

  val port = Properties.envOrElse("PORT", "5000").toInt
  Await.ready(Http.server.serve(s":$port", service))
}
