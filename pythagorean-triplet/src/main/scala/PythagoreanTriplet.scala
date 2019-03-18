import scala.math.max

object PythagoreanTriplet {
    def isPythagorean(sides: (Int, Int, Int)): Boolean = {
        def sqr(x: Int) = x * x
        val maxValue = max(max(sides._1, sides._2), sides._3)
        2 * sqr(maxValue) == sqr(sides._1) + sqr(sides._2) + sqr(sides._3)
    }

    def pythagoreanTriplets(start: Int, end: Int): Seq[(Int, Int, Int)] = Seq()
}
