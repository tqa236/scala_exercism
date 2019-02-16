object FlattenArray{
    def flatten(list: List[Any]): List[Any] = list match {
        case Nil => Nil
        case (h : List[_]) :: tail => flatten(h) ::: flatten(tail)
        case null :: tail => flatten(tail)
        case h :: tail => h :: flatten(tail)
    }
}
