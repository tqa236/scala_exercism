object CollatzConjecture{
    def steps(number: Int): Option[Int] = number match {
        case i if i <= 0 => None
        case 1 => Some(0)
        case i if i % 2 == 0 => steps(i/2).flatMap{x=>Some(1).map(x+_)}
        case i => steps(3*i+1).flatMap{x=>Some(1).map(x+_)}
    }
}
