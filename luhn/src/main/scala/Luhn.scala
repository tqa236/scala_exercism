object Luhn{
    def valid(input: String): Boolean = {
        val cleanInput = input.replaceAll("\\s", "")
        if (cleanInput == "0") false
        else if (!(cleanInput forall Character.isDigit)) false
        else {
            val digits = cleanInput.map(_.asDigit)
            List.range(0, cleanInput.length, 1)
                .map(i => if (i % 2 == cleanInput.length % 2)
                    digits(i) * 2 - 9 * (digits(i)/5)
                     else digits(i))
                .sum % 10 == 0
        }
    }
}
