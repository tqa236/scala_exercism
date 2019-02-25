object Strain {
    def keep[F[A]](numbers: F[A], predicate: A => Boolean): F[A] = List.empty
}
