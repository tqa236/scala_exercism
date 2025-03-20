import scala.util.control.Breaks.{break, breakable}

object MatchingBrackets {
  def isPaired(brackets: String): Boolean = {
    val stack = scala.collection.mutable.Stack[Char]()
    val openingBrackets = Set('[', '{', '(')
    val matchingBrackets = Map(']' -> '[', '}' -> '{', ')' -> '(')

    var isBalanced = true

    breakable {
      for (char <- brackets) {
        if (openingBrackets.contains(char)) {
          stack.push(char)
        } else if (matchingBrackets.contains(char)) {
          if (stack.isEmpty || stack.pop() != matchingBrackets(char)) {
            isBalanced = false
            break()
          }
        }
      }
    }

    isBalanced && stack.isEmpty
  }
}
