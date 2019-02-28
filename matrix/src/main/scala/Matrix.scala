case class Matrix(matrix: String) {
    val rows = matrix.split("\n")
                     .map(_.split(" ").map(_.toInt).to[Vector])
                     .to[Vector]

    def row(n: Int): Vector[Int] = rows(n)

    def column(n: Int): Vector[Int] = rows.map(_(n))
}
