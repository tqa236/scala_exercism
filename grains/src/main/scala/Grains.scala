import scala.math.pow

object Grains{
    def square(number: Int): Option[BigInt] = number match {
        case i if i <= 0 || i > 64 => None
        case i => Some(BigInt(2).pow(number - 1))
    }
    def total(): BigInt = BigInt(2).pow(64) - BigInt(1)
}
