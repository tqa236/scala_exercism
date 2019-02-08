object ArmstrongNumbers{
    def isArmstrongNumber(number: Int): Boolean = {
        val digits = number.toString.map(_.asDigit)
        val numDigit = digits.length
        digits.map(x => Math.pow(x,numDigit)).sum == number
    }
}
