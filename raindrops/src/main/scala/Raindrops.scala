object Raindrops {
    def convert(n: Int): String = {
        val sounds = Map(3 -> "Pling", 5 -> "Plang", 7 -> "Plong")
        val drops = sounds.filter(drop => n % drop._1 == 0).values
        if (drops.isEmpty) n.toString
        else drops.mkString
    }
}
