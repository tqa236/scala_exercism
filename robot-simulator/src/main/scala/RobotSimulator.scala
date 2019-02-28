object Bearing extends Enumeration {
  type Bearing = Value
  val North = Value(0)
  val East  = Value(1)
  val South = Value(2)
  val West  = Value(3)
}

import Bearing._
case class Robot (direction: Bearing, position: (Int, Int)){
    def bearing(): Bearing = direction
    def coordinates(): (Int, Int) = position

    def turnRight(): Robot = Robot(Bearing((direction.id + 1) % 4), position)

    def turnLeft(): Robot = Robot(Bearing((direction.id + 3) % 4), position)

    def advance(): Robot = {
        val newPosition = direction match {
            case Bearing.North => (position._1, position._2 + 1)
            case Bearing.West => (position._1 - 1, position._2)
            case Bearing.South => (position._1, position._2 - 1)
            case Bearing.East => (position._1 + 1, position._2)
        }
        Robot(direction, newPosition)
    }

    def move(robot: Robot, action: Char): Robot = action match {
        case 'R' => robot.turnRight
        case 'L' => robot.turnLeft
        case _ => robot.advance
    }

    def simulate(actions: String): Robot =
        actions.foldLeft(Robot(direction, position))(move)

}
