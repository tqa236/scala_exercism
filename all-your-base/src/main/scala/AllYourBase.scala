object AllYourBase{
    def rebase(inBase: Int, inDigits: List[Int], outBase: Int): Option[List[Int]] = {
        if (inBase < 2 || outBase < 2) None
        else if (inDigits == List()) Some(List(0))
        else if (inDigits.min < 0 || inDigits.max >= inBase) None
        else if (inDigits.sum == 0) Some(List(0))
        else Some(decToBase(baseToDec(inBase, inDigits), outBase).reverse)
    }

    def baseToDec(inBase: Int, inDigits: List[Int]): Int =
        inDigits.reduce(_ * inBase + _)

    def decToBase(decNum: Int, outBase: Int): List[Int] = decNum match {
        case 0 => List()
        case i => (i % outBase) +: decToBase(decNum / outBase, outBase)
    }
}
