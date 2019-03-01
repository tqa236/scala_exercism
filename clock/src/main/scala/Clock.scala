case class Clock(var hour: Int, var minute: Int){
    hour = ((hour.toFloat + minute.toFloat / 60).floor.toInt % 24 + 24) % 24
    minute = (minute % 60 + 60) % 60

    def +(that: Clock) = Clock(this.hour + that.hour, this.minute + that.minute)

    def -(that: Clock) = Clock(this.hour - that.hour, this.minute - that.minute)

    def ==(that: Clock) = this.hour == that.hour && this.minute == that.minute
}

object Clock{
    def apply(minute: Int) = new Clock(0, minute)
}
