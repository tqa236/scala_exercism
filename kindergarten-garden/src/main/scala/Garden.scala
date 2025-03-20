/** https://exercism.org/tracks/scala/exercises/kindergarten-garden */

enum Plant:
  case Grass, Violets, Radishes, Clover

object Plant:
  def apply(c: Char): Plant =
    c match
      case 'G' => Plant.Grass
      case 'V' => Plant.Violets
      case 'R' => Plant.Radishes
      case 'C' => Plant.Clover
      case _   => throw new IllegalArgumentException("Invalid plant character")

class Garden(rows: Array[Array[Char]]):
  def plants(name: String): List[Plant] =
    val index = (name.head - 'A') * 2
    List(
      Plant(rows(0)(index)),
      Plant(rows(0)(index + 1)),
      Plant(rows(1)(index)),
      Plant(rows(1)(index + 1))
    )

object Garden:
  def defaultGarden(s: String): Garden =
    val rows = s.split("\n").map(_.toArray)
    Garden(rows)