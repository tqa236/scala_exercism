import scala.collection.immutable.ListMap

class School {
    type DB = Map[Int, Seq[String]]

    var gradeSchool: DB = Map()

    def add(name: String, g: Int) {
        gradeSchool += (g -> (grade(g) :+ name))
    }

    def db: DB = gradeSchool

    def grade(g: Int): Seq[String] = gradeSchool.getOrElse(g,
        Seq.empty[String])

    def sorted: DB = gradeSchool.mapValues(_.sorted).toSeq.sortBy(_._1).toMap
    }
