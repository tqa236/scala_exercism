object BookStore {
    def total(books: List[Int]): Int = {
        if (books == List()) return 0
        val quantity = books.groupBy(identity).mapValues(_.size)
        val quantityList = quantity.toList.sortBy(_._2).map(_._2)
        println(quantityList)
        quantity.size match {
            // case 0 => 0
            case 1 => 800
            case 2 => (1600 * 0.95).toInt
            case 3 => (2400 * 0.9).toInt
            case 4 => (3200 * 0.8).toInt
            case 5 => (4000 * 0.75).toInt
        }
    }
}
