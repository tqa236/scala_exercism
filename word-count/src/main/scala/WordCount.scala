case class WordCount(sentence: String){
    val words = sentence
                .toLowerCase
                .replaceAll("[^a-z0-9\']", " ")
                .replaceAll("\' | \'|\" | \"", " ")
                .trim
                .split("\\s+")
    val countWords = words.groupBy(identity).mapValues(_.size)
}
