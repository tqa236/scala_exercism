object FoodChain {
  private val animals = Vector(
    "fly",
    "spider",
    "bird",
    "cat",
    "dog",
    "goat",
    "cow",
    "horse"
  )

  private val remarks = Map(
    "fly" -> "I don't know why she swallowed the fly. Perhaps she'll die.",
    "spider" -> "It wriggled and jiggled and tickled inside her.",
    "bird" -> "How absurd to swallow a bird!",
    "cat" -> "Imagine that, to swallow a cat!",
    "dog" -> "What a hog, to swallow a dog!",
    "goat" -> "Just opened her throat and swallowed a goat!",
    "cow" -> "I don't know how she swallowed a cow!",
    "horse" -> "She's dead, of course!"
  )

  private def generateVerse(verseNum: Int): String = {
    val animal = animals(verseNum - 1)
    val result = new StringBuilder()
    
    result.append(s"I know an old lady who swallowed a $animal.\n")
    result.append(s"${remarks(animal)}\n")
    
    if (animal == "horse") {
      return result.append("\n").toString()
    }
    
    if (animal != "fly") {
      buildChain(result, verseNum)
    }
    
    result.append("\n").toString()
  }
  
  private def buildChain(sb: StringBuilder, verseNum: Int): Unit = {
    for (i <- (verseNum - 1) to 1 by -1) {
      val predator = animals(i)
      val prey = animals(i - 1)
      
      if (prey == "spider") {
        sb.append(s"She swallowed the $predator to catch the $prey that wriggled and jiggled and tickled inside her.\n")
      } else {
        sb.append(s"She swallowed the $predator to catch the $prey.\n")
      }
    }
    
    sb.append(s"I don't know why she swallowed the fly. Perhaps she'll die.\n")
  }

  def recite(startVerse: Int, endVerse: Int): String = {
    (startVerse to endVerse).map(generateVerse).mkString
  }
}