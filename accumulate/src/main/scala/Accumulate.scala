import scala.annotation.tailrec

class Accumulate {
    @tailrec
    private[this] def tailAccumulate[A, B](f: (A) => B, result : List[B],
                remaining: List[A]): List[B] = remaining match {
        case Nil => result
        case x :: xs => tailAccumulate(f, f(x) :: result, xs)
    }

    def accumulate[A, B](f: (A) => B, list : List[A]): List[B] = {
        tailAccumulate(f, Nil, list).reverse
    }
}
