import scala.collection.mutable
import scala.util.Try

object Alphametics {

  def solve(puzzle: String): Option[Map[Char, Int]] = {
    // Extract the unique letters from the puzzle
    val letters = extractLetters(puzzle)
    if (letters.size > 10) return None  // There are only 10 digits, can't have more than 10 letters

    // Generate all permutations of digits for the letters
    val permutations = generatePermutations(letters.size)

    // Try all permutations
    permutations.collectFirst {
      case perm if isValidSolution(puzzle, letters, perm) =>
        letters.zip(perm).toMap
    }
  }

  // Extracts all the unique letters in the puzzle
  private def extractLetters(puzzle: String): Set[Char] = {
    puzzle.filter(_.isLetter).toSet
  }

  // Generates all possible permutations of digits for the given size
  private def generatePermutations(size: Int): Seq[Seq[Int]] = {
    val digits = (0 to 9).toSeq
    digits.permutations.toSeq.filter(_.size == size)
  }

  // Checks if a given permutation satisfies the puzzle
  private def isValidSolution(puzzle: String, letters: Set[Char], perm: Seq[Int]): Boolean = {
    val letterToDigit = letters.zip(perm).toMap

    // Replace the letters with their corresponding digits in the puzzle string
    val puzzleWithDigits = puzzle.map {
      case letter if letter.isLetter => letterToDigit(letter).toString
      case char => char.toString
    }.mkString  // Convert the sequence back into a string

    // Now split the puzzle into left and right parts at "=="
    val splitPuzzle = puzzleWithDigits.split("==")
    if (splitPuzzle.length != 2) return false
    val (left, right) = (splitPuzzle(0).trim, splitPuzzle(1).trim)

    // Check for leading zeros
    if (hasLeadingZero(left) || hasLeadingZero(right)) return false

    // Convert both sides to numbers and compare
    val leftResult = evaluateExpression(left)
    val rightResult = evaluateExpression(right)

    leftResult == rightResult
  }

  // Check if the string has a leading zero (e.g., "012" or "01")
  private def hasLeadingZero(s: String): Boolean = {
    s.nonEmpty && s.head == '0' && s.length > 1
  }

  // Evaluates an arithmetic expression with digits (handles + and other operations)
  private def evaluateExpression(expr: String): Int = {
    val operands = expr.split("\\+").map(_.trim)
    operands.map(_.toInt).sum
  }
}
