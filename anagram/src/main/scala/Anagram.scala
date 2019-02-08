object Anagram{
    def findAnagrams(input: String, candidates : List[String]): List[String] = {
        val inputChars = input.toLowerCase().toList.sorted
        candidates.filter(x => (x.toLowerCase().toList.sorted ==
            inputChars && x.toLowerCase() != input.toLowerCase()))
    }
}
