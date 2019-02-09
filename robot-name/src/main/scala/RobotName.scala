import scala.util.Random

object Robot {

  private var unused: List[String] = Random.shuffle(
      for {
        letter1 <- (0 until 26).map(x => ('A' + x).toChar)
        letter2 <- (0 until 26).map(x => ('A' + x).toChar)
        numbers <- 0 until 1000
      } yield List(letter1, letter2, "%03d".format(numbers)).mkString
    ).toList

  private def obtain(): String = unused match {
    case elem :: list =>
      unused = list
      elem
    case _ => ""
  }
}

class Robot {

  var name: String = Robot.obtain()

  def reset(): Unit = name = Robot.obtain()
}
