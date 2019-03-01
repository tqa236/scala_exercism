object Allergen extends Enumeration {
  type Allergen = Value
  val Eggs = Value(1)
  val Peanuts = Value(2)
  val Shellfish  = Value(4)
  val Strawberries = Value(8)
  val Tomatoes  = Value(16)
  val Chocolate  = Value(32)
  val Pollen = Value(64)
  val Cats  = Value(128)
}

object Allergies{
    import Allergen._

    def allergicTo(allergen: Allergen, score: Int): Boolean =
        (score & allergen.id) != 0

    def list(score: Int): List[Allergen] =
        Allergen.values.filter(allergicTo(_, score)).toList
}
