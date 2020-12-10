import scala.collection.immutable.ListMap

class School {
    type DB = Map[Int, Seq[String]]

    var grade_school: DB = Map()

    def add(name: String, g: Int) =  grade_school.get(g) match {
        case Some(xs:Seq[String]) => grade_school += (g -> (xs :+ name))
        case None => grade_school += (g -> Seq(name))
    }

    def db: DB = grade_school

    def grade(g: Int): Seq[String] = grade_school.get(g) match {
        case Some(xs:Seq[String]) => xs
        case None => Seq()
    }

    def sorted: DB = ListMap(grade_school.toSeq.sortBy(_._1):_*)
                            .mapValues(_.sorted)
}
