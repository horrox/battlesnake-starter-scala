package starter

import io.circe._

case class Game(id: String, ruleset: Json, timeout: Int)

case class Point(x: Int, y: Int)

case class Battlesnake(
    id: String,
    name: String,
    squad: Option[String],
    health: Int,
    latency: String,
    length: Int,
    head: Point,
    body: Array[Point],
    shout: String
)

case class Board(
    height: Int,
    width: Int,
    food: Array[Point],
    hazards: Array[Point],
    snakes: Array[Battlesnake]
)

case class GameState(game: Game, turn: Int, board: Board, you: Battlesnake)
