case class Matrix(matrix: String) {
    private val rows = matrix.lines
                     .map(_.split(" ").map(_.toInt).toVector)
                     .toVector

    def row(n: Int): Vector[Int] = rows(n)

    def column(n: Int): Vector[Int] = rows.map(_(n))
}
