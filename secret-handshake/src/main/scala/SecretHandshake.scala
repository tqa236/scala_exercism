object SecretHandshake{
    def commands(number: Int): List[String] = {
        val actions = List("wink", "double blink", "close your eyes", "jump")
        val values = (0 to 3).map(x => scala.math.pow(2, x).toInt)
        val handshake = actions.zip(values).collect{
            case (action, value) if ((number & value) == value) => action
        }
        number & 16 match {
            case 16 => handshake.reverse
            case _ => handshake
        }
    }
}
