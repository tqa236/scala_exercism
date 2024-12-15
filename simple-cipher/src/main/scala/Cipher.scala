import scala.util.Random

class Cipher(val key: String) {
  require(key.forall(_.isLower), "Key must contain only lowercase letters.")
  require(key.nonEmpty, "Key cannot be empty.")

  private val alphabet = 'a' to 'z'
  private val alphabetSize = alphabet.size

  def encode(plaintext: String): String = {
    plaintext.zip(Stream.continually(key).flatten).map {
      case (char, keyChar) =>
        val shift = keyChar - 'a'
        val encodedChar = ((char - 'a' + shift) % alphabetSize + 'a').toChar
        encodedChar
    }.mkString
  }

  def decode(ciphertext: String): String = {
    ciphertext.zip(Stream.continually(key).flatten).map {
      case (char, keyChar) =>
        val shift = keyChar - 'a'
        val decodedChar = ((char - 'a' - shift + alphabetSize) % alphabetSize + 'a').toChar
        decodedChar
    }.mkString
  }
}

object Cipher {
  private val randomKeyLength = 100
  private val alphabet = 'a' to 'z'

  def apply(key: Option[String]): Cipher = key match {
    case Some(providedKey) => new Cipher(providedKey)
    case None => new Cipher(Random.alphanumeric.filter(_.isLower).take(randomKeyLength).mkString)
  }
}