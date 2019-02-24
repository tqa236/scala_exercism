object SecretHandshake{
    def commands(number: Int): List[String] = {
        val binaryNumber = toBinary(number).reverse.map(_.toString).toList
        val actions = List("wink", "double blink", "close your eyes", "jump")

        val handshake = actions.zip(binaryNumber).filter(_._2 == "1").map(_._1)

        binaryNumber.last match {
            case "1" => handshake.reverse
            case _ => handshake
        }

    }

    def toBinary(i: Int, digits: Int = 5) =
        String.format("%" + digits + "s", i.toBinaryString).replace(' ', '0')

    }
