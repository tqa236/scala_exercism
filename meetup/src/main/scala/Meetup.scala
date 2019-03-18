import java.time.{DayOfWeek, LocalDate}
import java.time.temporal.TemporalAdjusters.{nextOrSame}

import Schedule.Schedule

case class Meetup(month: Int, year: Int) {

  def day(dayOfWeek: DayOfWeek, schedule: Schedule): LocalDate = {
      val startDay = schedule match {
          case Schedule.Last => schedule.id + LocalDate.of(year, month, 1).lengthOfMonth
          case _ => schedule.id
      }
      LocalDate.of(year, month, startDay).`with`(nextOrSame(dayOfWeek))
  }

}

object Schedule extends Enumeration {
  type Schedule = Value
  val First = Value(1)
  val Second = Value(8)
  val Third = Value(15)
  val Fourth = Value(22)
  val Teenth = Value(13)
  val Last = Value(-6)
}

object Meetup {
  val Mon = DayOfWeek.MONDAY
  val Tue = DayOfWeek.TUESDAY
  val Wed = DayOfWeek.WEDNESDAY
  val Thu = DayOfWeek.THURSDAY
  val Fri = DayOfWeek.FRIDAY
  val Sat = DayOfWeek.SATURDAY
  val Sun = DayOfWeek.SUNDAY
}
