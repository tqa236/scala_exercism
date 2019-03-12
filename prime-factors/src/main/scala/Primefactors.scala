object PrimeFactors{
    def factors(number: Long): List[Long] = number match {
        case 1 => List.empty[Long]
        case number if number % 2 == 0 => 2 :: factors(number/2)
        case number => factorsWithOddFactor(number, 3)
    }

    def factorsWithOddFactor(number: Long, factor: Long): List[Long] = number match {
        case 1 => List.empty[Long]
        case number if number % factor == 0 => factor :: factorsWithOddFactor(number/factor, factor)
        case number => factorsWithOddFactor(number, factor + 2)
    }

}
