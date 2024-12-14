object PythagoreanTriplet {

  def isPythagorean(triplet: (Int, Int, Int)): Boolean = {
    val (a, b, c) = triplet
    a * a + b * b == c * c
  }

  def pythagoreanTriplets(start: Int, end: Int): Seq[(Int, Int, Int)] = {
    for {
      a <- start to end
      b <- a + 1 to end
      c <- b + 1 to end
      if isPythagorean((a, b, c))
    } yield (a, b, c)
  }

  def pythagoreanTripletsSum(N: Int): Seq[(Int, Int, Int)] = {
    for {
      a <- 1 until N
      b <- a + 1 until N - a
      c = N - a - b
      if c > b && isPythagorean((a, b, c))
    } yield (a, b, c)
  }
}
