object House {
    def recite(verseStart: Int, verseEnd: Int): String = {
        reciteOneVerse(verseStart)
    }

    def reciteOneVerse(verse: Int): String = {
        val actions = List(
          ("lay in"     , " the house that Jack built.")
        , ("ate"        , " the malt")
        , ("killed"     , " the rat")
        , ("worried"    , " the cat")
        , ("tossed"     , " the dog")
        , ("milked"     , " the cow with the crumpled horn")
        , ("kissed"     , " the maiden all forlorn")
        , ("married"    , " the man all tattered and torn")
        , ("woke"       , " the priest all shaven and shorn")
        , ("kept"       , " the rooster that crowed in the morn")
        , ("belonged to", " the farmer sowing his corn")
        , (""           , " the horse and the hound and the horn")
        )
    s"""This is${actions(0)._2}\n\n"""
}
}
