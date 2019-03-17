object Series{
    def largestProduct(size: Int, number: String): Option[Int] = size match {
        case 0 => Some(1)
        case size if (size < 0 || size > number.length) => None
        case size if (!(number forall Character.isDigit)) => None
        case _ => Some(number.map(_.asDigit).sliding(size).map(_.product).max)
    }
}
