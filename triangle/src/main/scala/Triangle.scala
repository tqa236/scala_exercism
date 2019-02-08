case class Triangle(side1: Double, side2: Double, side3: Double){
    val sides = List(side1, side2, side3).sorted
    val numDistinctSides = sides.distinct.length
    val isValidTriangle = sides(0) > 0 && sides(0) + sides(1) > sides(2)
    val equilateral = numDistinctSides == 1 && isValidTriangle
    val isosceles = numDistinctSides <= 2 && isValidTriangle
    val scalene = numDistinctSides == 3 && isValidTriangle
}
