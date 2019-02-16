import org.scalatest.{Matchers, FlatSpec}

/** @version created manually **/
class AccumulateTest extends FlatSpec with Matchers {

  it should "allow empty accumulation" in {
    val accumulate = new Accumulate
    val accumulation = accumulate.accumulate[Int, Int](x => x * x, List.empty)
    accumulation should be (List.empty)
  }

  it should "accumulate squares temp 2" in {
    // pending
    val accumulate = new Accumulate
    val accumulation = accumulate.accumulate[Int, Int](x => x * x, List(1))
    accumulation should be (List(1))
  }

  it should "accumulate squares temp" in {
    // pending
    val accumulate = new Accumulate
    val accumulation = accumulate.accumulate[Int, Int](x => x * x, List(1, 2, 3, 4, 5))
    accumulation should be (List(1, 4, 9, 16, 25))
  }

  it should "accumulate squares" in {
    // pending
    val accumulate = new Accumulate
    val accumulation = accumulate.accumulate[Int, Int](x => x * x, List(1, 2, 3))
    accumulation should be (List(1, 4, 9))
  }

  it should "accumulate upcases" in {
    // pending
    val accumulate = new Accumulate
    val accumulation = accumulate.accumulate[String, String](_.map(_.toUpper), List("hello", "world"))
    accumulation should be (List("HELLO", "WORLD"))
  }

  it should "accumulate reversed strings" in {
    // pending
    val accumulate = new Accumulate
    val accumulation = accumulate.accumulate[String, String](_.reverse, List("eht", "kciuq", "nworb", "xof", "cte"))
    accumulation should be (List("the", "quick", "brown", "fox", "etc"))
  }

  it should "allow different return type" in {
    // pending
    val accumulate = new Accumulate
    val accumulation = accumulate.accumulate[Int, String](_.toString, List(1, 2, 3))
    accumulation should be (List("1", "2", "3"))
  }
}
