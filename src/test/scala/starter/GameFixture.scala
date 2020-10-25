package starter

import io.circe.Json

trait GameFixture {
  def basicGame: GameState = {
    val mySnake = Battlesnake(
      id = "me",
      name = "me",
      squad = None,
      health = 100,
      latency = "50",
      length = 2,
      head = Point(2, 8),
      body = Array(Point(2, 8), Point(2, 7)),
      shout = "whatever"
    )

    GameState(
      Game(id = "totally-unique-game-id", ruleset = Json.Null, timeout = 500),
      turn = 0,
      Board(
        height = 11,
        width = 11,
        food = Array(Point(5, 5)),
        hazards = Array(),
        snakes = Array(mySnake)
      ),
      you = mySnake
    )
  }
}
