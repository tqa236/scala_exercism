import scala.math.sqrt

object Darts{
    def score(x: Double, y: Double): Int = {
        val distance = sqrt(x*x + y*y)
        if (distance > 10) 0
        else if (distance > 5) 1
        else if (distance > 1) 5
        else 10
    }
}
