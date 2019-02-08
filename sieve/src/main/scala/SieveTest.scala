object Sieve{
    def primes(number: Int): List[Int] = {
        if (number < 2) List()
        else nextPrime(List(), List.range(2, number+1))
    }

    def nextPrime(primes: List[Int], numbers: List[Int]): List[Int] = {
        if (numbers == Nil) primes
        else{
            val prime = numbers.head
            nextPrime(primes :+ prime, numbers.filter(_ % prime != 0))
        }

    }
}
