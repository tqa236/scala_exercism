object Bob {
  def response(statement: String): String = {
      val isEmpty = statement.replaceAll("\\s", "") == ""
      val isQuestion = statement.replaceAll("\\s", "").takeRight(1) == "?"
      val isYelling = statement.exists(_.isUpper) && !statement.exists(_.isLower)

      if (isEmpty) "Fine. Be that way!"
      else if (isQuestion){
          if (isYelling) "Calm down, I know what I'm doing!"
          else "Sure."
      }
      else if (isYelling) "Whoa, chill out!"
      else "Whatever."
  }
}
