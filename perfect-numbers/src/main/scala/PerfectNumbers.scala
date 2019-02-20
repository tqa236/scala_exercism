import scala.math.sqrt

object NumberType extends Enumeration {
    type NumberType = Value
    val Perfect, Abundant, Deficient = Value
}

object PerfectNumbers{
    import NumberType._

    def classify(number: Int): Either[String, NumberType] = {
        if (number <= 0) Left("Classification is only possible for natural numbers.")
        else {
            val squareRoot = sqrt(number).toInt
            val smallDivisors = List.range(1, squareRoot + 1).filter(number % _ == 0)
            val bigDivisors = smallDivisors.map(number / _)
            val sqrtDivisor = number match {
                case i if i == squareRoot * squareRoot => squareRoot
                case _ => 0
            }

            val divisorSum = smallDivisors.sum + bigDivisors.sum - sqrtDivisor - number
            divisorSum match {
                case i if i == number => Right(NumberType.Perfect)
                case i if i > number => Right(NumberType.Abundant)
                case _ => Right(NumberType.Deficient)
            }
        }
    }

}
