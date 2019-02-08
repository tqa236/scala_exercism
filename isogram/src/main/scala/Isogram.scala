object Isogram{
    def isIsogram(text: String): Boolean = {
        val letters = text.replaceAll("[^A-Za-z]", "").toLowerCase()
        letters.length == letters.distinct.length
    }
}
