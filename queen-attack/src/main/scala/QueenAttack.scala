case class Queen(row: Int, column: Int)

object Queen {
  def create(row: Int, column: Int): Option[Queen] = {
    if (row >= 0 && row < 8 && column >= 0 && column < 8) {
      Some(Queen(row, column))
    } else {
      None
    }
  }
}

object QueenAttack {
  def canAttack(q1: Queen, q2: Queen): Boolean = {
    q1.row == q2.row || 
    q1.column == q2.column || 
    math.abs(q1.row - q2.row) == math.abs(q1.column - q2.column) 
  }
}
