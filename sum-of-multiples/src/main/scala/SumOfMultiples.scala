object SumOfMultiples {
  def sum(factors: Set[Int], limit: Int): Int = {
    var removed = List.range(1, limit)
    for (factor <- factors){
      removed = removed.filterNot(_ % factor == 0)
    }
    List.range(1, limit).sum - removed.sum
  }
}
