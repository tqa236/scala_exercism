import scala.annotation.tailrec

object NthPrime {
  def prime(n: Int): Option[BigInt] = n match {
      case 0 => None
      case n => {
          @tailrec
          def generate(currentPrime: BigInt = 2, counter: Int = 1): BigInt = counter match {
              case `n` => currentPrime
              case counter => generate(currentPrime.bigInteger.nextProbablePrime, counter + 1)
          }
          Some(generate())
      }
  }
}
