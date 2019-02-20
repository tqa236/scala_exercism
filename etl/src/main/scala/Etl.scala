object Etl{
    def transform(values: Map[Int, Seq[String]]): Map[String, Int] = {
        values.toSeq.flatMap { case (a, b) => b.map(_.toLowerCase() -> a)}.toMap
    }
}
