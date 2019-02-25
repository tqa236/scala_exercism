object HighScores{
    def latest(scores: List[Int]): Int = scores.last
    def personalBest(scores: List[Int]): Int = scores.max
    def personalTop(scores: List[Int]): List[Int] = scores.sortWith(_ > _).take(3)
    def report(scores: List[Int]): String = {
        val latestScore = latest(scores)
        val bestScore = personalBest(scores)
        latestScore match {
            case i if i == bestScore => s"Your latest score was ${latestScore}. That's your personal best!"
            case _ => s"Your latest score was ${latestScore}. That's ${bestScore - latestScore} short of your personal best!"
        }
    }
}
