import scala.math.sqrt

object Darts{
    def score(x: Double, y: Double): Int = {
        val distance = sqrt(x*x + y*y)
        distance match {
            case i if i > 10 => 0
            case i if i > 5 => 1
            case i if i > 1 => 5
            case _ => 10
        }
    }
}
