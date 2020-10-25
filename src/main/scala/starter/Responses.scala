package starter

case class ServerInfo(
    apiversion: String,
    author: String,
    color: String,
    head: String,
    tail: String
)

case class Move(move: String, shout: String)
