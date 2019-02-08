object CollatzConjecture{
    def steps(number: Int): Option[Int] = {
        if (number <= 0) None
        else if (number == 1) Some(0)
        else if (number % 2 == 0){
            steps(number/2).flatMap{x=>Some(1).map(x+_)}
        }
        else steps(3*number+1).flatMap{x=>Some(1).map(x+_)}
    }
}
