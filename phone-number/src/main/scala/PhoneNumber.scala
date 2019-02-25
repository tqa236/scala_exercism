object PhoneNumber{
    def clean(number: String): Option[String] = {
        val cleanNumber = number.filter(_.isDigit)
        cleanNumber match {
            case i if i.length < 10 || i.length > 11 => None
            case i if i.takeRight(10)(0).asDigit < 2 => None
            case i if i.takeRight(7)(0).asDigit < 2 => None
            case i if i.length == 11 && i(0) != '1' => None
            case _ => Some(cleanNumber.takeRight(10))
        }
    }
}
