object Series{
    def largestProduct(size: Int, number: String): Option[Int] = {
        if (size == 0) Some(1)
        else if (size < 0 || size > number.length) None
        else if (!(number forall Character.isDigit)) None
        else Some(number.map(_.asDigit).sliding(size).map(_.product).max)
    }
}
