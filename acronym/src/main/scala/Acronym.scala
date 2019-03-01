object Acronym {
  def abbreviate(phrase: String): String =
      phrase.replaceAll("[^a-zA-Z']", " ")
            .split(" +")
            .map(_(0))
            .mkString
            .toUpperCase
}
