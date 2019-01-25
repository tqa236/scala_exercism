object SumOfMultiples {
  def sum(factors: Set[Int], limit: Int): Int = {
    val factor_list = List.empty[Int] ++ factors
    def remove(factor_list: List[Int], removed: List[Int]) : List[Int] = {
      factor_list match {
        case Nil => removed
        case x :: xs => remove(xs, removed.filterNot(_ % x == 0))
      }
    }
    List.range(1, limit).sum - remove(factor_list, List.range(1, limit)).sum
  }
}
