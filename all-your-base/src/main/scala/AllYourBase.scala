object AllYourBase{
    def rebase(inBase: Int, inDigits: List[Int], outBase: Int): Option[List[Int]] = inDigits match {
        case inDigits if (inBase < 2 || outBase < 2) => None
        case inDigits if (inDigits == List()) => Some(List(0))
        case inDigits if (inDigits.min < 0 || inDigits.max >= inBase) => None
        case inDigits if (inDigits.sum == 0) => Some(List(0))
        case _ => Some(decToBase(baseToDec(inBase, inDigits), outBase).reverse)
    }

    def baseToDec(inBase: Int, inDigits: List[Int]): Int =
        inDigits.reduce(_ * inBase + _)

    def decToBase(decNum: Int, outBase: Int): List[Int] = decNum match {
        case 0 => List()
        case i => (i % outBase) +: decToBase(decNum / outBase, outBase)
    }
}
