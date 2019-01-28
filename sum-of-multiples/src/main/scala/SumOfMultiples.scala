object SumOfMultiples {
  def sum(factors: Set[Int], limit: Int): Int = {
    List.range(1, limit).filter(x => factors.exists(x % _ == 0)).sum
  }
}
