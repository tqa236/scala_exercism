object BeerSong {
    def recite(verse: Int, length: Int): String = length match {
        case 1 => reciteOneVerse(verse)
        case _ => reciteOneVerse(verse) + "\n" + recite(verse - 1, length - 1)
    }

    def reciteOneVerse(verse: Int): String = verse match {
        case 0 => "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n"
        case _ => {
            def bottle(verse: Int): String = verse match {
                case 0 => "no more bottles"
                case 1 => s"1 bottle"
                case _ => s"$verse bottles"
            }
            val action = verse match {
                case 1 => "Take it down and pass it around, "
                case _ => "Take one down and pass it around, "
            }
            s"${bottle(verse)} of beer on the wall, ${bottle(verse)} of beer.\n$action${bottle(verse - 1)} of beer on the wall.\n"
        }
    }
}
