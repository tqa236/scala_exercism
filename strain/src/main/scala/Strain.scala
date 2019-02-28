object Strain {
    def keep[A](items: Seq[A], predicate: A => Boolean): Seq[A] = items
    .foldLeft(Seq.empty[A])((result, item) => if (predicate(item)) item +: result else result)
    .reverse

    def discard[A](items: Seq[A], predicate: A => Boolean): Seq[A] = {
        keep(items, !predicate(_:A))
    }
}
