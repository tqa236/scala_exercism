object BinarySearch{
    def find(numbers: List[Int], number: Int): Option[Int] = numbers.length match {
        case 0 => None
        case i if numbers((i - 1)/2) == number => Some((i - 1)/2)
        case i if numbers((i - 1)/2) > number => find(numbers.take((i - 1)/2 - 1), number)
        case i => Some((i - 1)/2 + 1).flatMap{x => find(numbers.drop((i - 1)/2 + 1), number).map(x+_)}
    }
}
