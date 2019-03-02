object PascalsTriangle{
    def rows(number: Int): List[List[Int]] = number match {
        case 1 => List(List(1))
        case i if i > 1 => rows (i - 1)  :+
            (0 +: rows (i - 1).last :+ 0).sliding(2).map(_.sum).toList
        case _ => List()
    }
}
