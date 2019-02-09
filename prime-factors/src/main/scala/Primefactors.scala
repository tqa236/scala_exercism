object PrimeFactors{
    def factors(number: Long): List[Long] = number match {
        case 1 => List()
        case number if number % 2 == 0 => List(2)
    }
}
