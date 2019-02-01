object DifferenceOfSquares {

    def sumOfSquares(n: Int): Int = (1 to n).map(square).sum

    def squareOfSum(n: Int): Int = square((1 to n).sum)

    def differenceOfSquares(n: Int): Int = squareOfSum(n) - sumOfSquares(n)

    private def square(n: Int): Int = n * n
}
