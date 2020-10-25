package starter

import com.twitter.io.Buf
import io.circe.generic.auto._
import io.circe.syntax._
import io.finch._
import org.scalatest.{AsyncFlatSpec, Matchers}

class MainSpec extends AsyncFlatSpec with Matchers with GameFixture {
  "Main" should "share server info" in {
    Main.info(Input.get("/")).awaitValueUnsafe() match {
      case Some(serverInfo) =>
        serverInfo shouldBe a[ServerInfo]
      case None => fail("Result of '/' was not ServerInfo")
    }
  }

  it should "respond to move" in {
    val request = Input
      .post("/move")
      .withBody[Application.Json](Buf.Utf8(basicGame.asJson.toString()))

    Main.move(request).awaitValueUnsafe() match {
      case Some(move) =>
        move shouldBe a[Move]
      case None => fail("Result of '/move' was not a Move")
    }
  }

  it should "respond to start" in {
    val startRequest = Input
      .post("/start")
      .withBody[Application.Json](Buf.Utf8(basicGame.asJson.toString()))

    Main.start(startRequest).awaitValueUnsafe() shouldBe Some(())
  }

  it should "respond to end" in {
    val endRequest = Input
      .post("/end")
      .withBody[Application.Json](Buf.Utf8(basicGame.asJson.toString()))

    Main.end(endRequest).awaitValueUnsafe() shouldBe Some(())
  }
}
