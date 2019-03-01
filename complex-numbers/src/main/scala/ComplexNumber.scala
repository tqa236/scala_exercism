case class ComplexNumber(real: Double = 0, imaginary: Double = 0) {

    def +(that: ComplexNumber) =
        ComplexNumber(this.real + that.real, this.imaginary + that.imaginary)

    def -(that: ComplexNumber) =
        ComplexNumber(this.real - that.real, this.imaginary - that.imaginary)

    def *(that: ComplexNumber) =
        ComplexNumber(this.real * that.real - this.imaginary * that.imaginary,
            this.imaginary * that.real + this.real * that.imaginary)

    def /(that: ComplexNumber) =
        ComplexNumber((this.real * that.real + this.imaginary * that.imaginary)/
        (scala.math.pow(that.real, 2) + scala.math.pow(that.imaginary, 2)),
         (this.imaginary * that.real - this.real * that.imaginary)/
         (scala.math.pow(that.real, 2) + scala.math.pow(that.imaginary, 2)))

    def abs() =
        scala.math.sqrt(scala.math.pow(real, 2) + scala.math.pow(imaginary, 2))
    def conjugate = ComplexNumber(real, - imaginary)

}

object ComplexNumber{
    def exp(number: ComplexNumber): ComplexNumber =
        ComplexNumber(scala.math.exp(number.real) *
        scala.math.cos(number.imaginary),
         scala.math.exp(number.real) *
          scala.math.sin(number.imaginary))
}
