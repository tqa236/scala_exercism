object Bob {
  def response(statement: String): String = {
    ( statement.exists(_.isLower), statement.replaceAll("\\s", "").takeRight(1) == "?", statement.exists(_.isUpper), statement.replaceAll("\\s", "") == "") match {
      case (other, other2, other3, true) => "Fine. Be that way!"
      case (false, false, false, other) => "Whatever."
      case (false, true, false, other) => "Sure."
      case (false, true, other, other2) => "Calm down, I know what I'm doing!"
      case (false, false, other, other2) => "Whoa, chill out!"
      case (other, true, other2, other3) => "Sure."
      case other => "Whatever."
    }
  }
}
