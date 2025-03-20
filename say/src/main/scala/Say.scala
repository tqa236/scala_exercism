object Say {
  private val units = Array("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
  private val teens = Array("ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen")
  private val tens = Array("twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety")
  private val thousands = Array("", "thousand", "million", "billion")

  def inEnglish(number: Long): Option[String] = {
    if (number < 0 || number > 999999999999L) None
    else if (number == 0) Some(units(0))
    else {
      val chunks = splitIntoChunks(number)
      val parts = chunks.zipWithIndex.map { case (chunk, idx) =>
        if (chunk > 0) s"${chunkToWords(chunk)} ${thousands(idx)}".trim else ""
      }.filter(_.nonEmpty).reverse.mkString(" ")
      Some(parts)
    }
  }

  private def splitIntoChunks(number: Long): Array[Int] = {
    number.toString.reverse.grouped(3).toArray.map(_.reverse.toInt)
  }

  private def chunkToWords(chunk: Int): String = {
    val hundred = chunk / 100
    val rest = chunk % 100
    val hundredPart = if (hundred > 0) s"${units(hundred)} hundred" else ""
    val restPart = if (rest == 0) "" else if (rest < 10) units(rest)
    else if (rest < 20) teens(rest - 10)
    else {
      val ten = rest / 10
      val unit = rest % 10
      if (unit > 0) s"${tens(ten - 2)}-${units(unit)}" else tens(ten - 2)
    }
    Seq(hundredPart, restPart).filter(_.nonEmpty).mkString(" ")
  }
}