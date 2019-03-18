object Sublist extends Enumeration {
  type Sublist = Value
  val Equal, Sublist, Superlist, Unequal = Value

  def sublist(a: List[Int], b: List[Int]): Sublist = {
      val isSublist = b.containsSlice(a)
      val isSuperlist = a.containsSlice(b)
      (isSublist, isSuperlist) match {
          case (true, true) => Equal
          case (true, false) => Sublist
          case (false, true) => Superlist
          case _ => Unequal
      }
  }
}
