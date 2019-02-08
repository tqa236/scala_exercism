object Pangrams {
  def isPangram(input: String): Boolean = {
      input.replaceAll("[^A-Za-z]", "").toLowerCase().distinct.length == 26
  }
}
