object House {
    
  private val parts = List(
    "the horse and the hound and the horn that belonged to",
    "the farmer sowing his corn that kept",
    "the rooster that crowed in the morn that woke",
    "the priest all shaven and shorn that married",
    "the man all tattered and torn that kissed",
    "the maiden all forlorn that milked",
    "the cow with the crumpled horn that tossed",
    "the dog that worried",
    "the cat that killed",
    "the rat that ate",
    "the malt that lay in",
    "the house that Jack built"
  )

  private def verse(n: Int): String = {
    val verseParts = parts.takeRight(n).mkString(" ")
    s"This is $verseParts.\n"
  }

  def recite(start: Int, end: Int): String = {
    (start to end).map(verse).mkString("") + "\n"
  }
}
