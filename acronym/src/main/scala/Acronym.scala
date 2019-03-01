object Acronym {
  def abbreviate(phrase: String): String =
      phrase.split("( |-)+").map(_.charAt(0).toUpper).mkString
}
