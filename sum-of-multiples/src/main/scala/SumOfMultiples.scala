object SumOfMultiples {
  def sum(factors: Set[Int], limit: Int): Int = {
    val numbers = List.range(1, limit)
    val boi = List.range(1,3,10).toSet
    val Set[Int] multiples_1 = numbers.filter(_ % 3 == 0)
    val multiples_2 = numbers.filter(_ % 5 == 0)
    val multiples = List.concat(multiples_1, multiples_2)

    def sum(list: List[Int]): Int = list match {
        case Nil => 0
        case x :: xs => x + sum(xs)
    }
    sum(multiples_1)
  }
}
