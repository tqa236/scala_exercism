import scala.collection.immutable.ListMap

class School {
    type DB = Map[Int, Seq[String]]

    var grade_school: DB = Map()

    def add(name: String, g: Int) {
        grade_school += (g -> (grade(g) :+ name))
    }

    def db: DB = grade_school

    def grade(g: Int): Seq[String] = grade_school.getOrElse(g,
        Seq.empty[String])

    def sorted: DB = grade_school.mapValues(_.sorted).toSeq.sortBy(_._1).toMap
    }
