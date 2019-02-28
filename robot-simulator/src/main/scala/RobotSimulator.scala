object Bearing extends Enumeration {
    type Bearing = Value
    val North, South, East, West = Value
}

import Bearing._
case class Robot (direction: Bearing, position: (Int, Int)){
    def bearing(): Bearing = direction
    def coordinates(): (Int, Int) = position

    def turnRight(): Robot = {
        val newDirection = direction match {
            case Bearing.North => Bearing.East
            case Bearing.East => Bearing.South
            case Bearing.South => Bearing.West
            case Bearing.West => Bearing.North
        }
        Robot(newDirection, position)
    }

    def turnLeft(): Robot = {
        val newDirection = direction match {
            case Bearing.North => Bearing.West
            case Bearing.West => Bearing.South
            case Bearing.South => Bearing.East
            case Bearing.East => Bearing.North
        }
        Robot(newDirection, position)
    }

    def advance(): Robot = {
        val newPosition = direction match {
            case Bearing.North => (position._1, position._2 + 1)
            case Bearing.West => (position._1 - 1, position._2)
            case Bearing.South => (position._1, position._2 - 1)
            case Bearing.East => (position._1 + 1, position._2)
        }
        Robot(direction, newPosition)
    }

    def simulate(actions: String): Robot = {
        actions.toList match {
            case List() => Robot(direction, position)
            case x :: tail => x match {
                case 'R' => Robot(direction, position).turnRight.simulate(tail.mkString)
                case 'L' => Robot(direction, position).turnLeft.simulate(tail.mkString)
                case _ => Robot(direction, position).advance.simulate(tail.mkString)
            }

        }

    }

}

// object Robot{
// // object Robot extends ((Bearing, (Int, Int)) => Robot) {
//     def turnRight(robot: Robot): Robot = {
//         val newDirection = robot.bearing match {
//             case Bearing.North => Bearing.East
//             case Bearing.East => Bearing.South
//             case Bearing.South => Bearing.West
//             case Bearing.West => Bearing.North
//         }
//         return Robot(newDirection, robot.coordinates)
//     }
//
// }
