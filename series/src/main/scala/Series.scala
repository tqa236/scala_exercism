object Series{
    def slices(size: Int, number: String): Seq[Seq[Int]] =
        number.map(_.asDigit).sliding(size).toSeq
}
