object ProteinTranslation{
    def proteins(rna: String): Seq[String] = {
        val groups = rna.grouped(3).toList
        groups.map(toProtein).takeWhile(_ != "STOP")
    }

    def toProtein (codon: String): String = codon match {
        case "AUG" => "Methionine"
        case "UUU" | "UUC" => "Phenylalanine"
        case "UUA" | "UUG" => "Leucine"
        case "UCU" | "UCC" | "UCA" | "UCG" => "Serine"
        case "UAU" | "UAC" => "Tyrosine"
        case "UGU" | "UGC" => "Cysteine"
        case "UGG" => "Tryptophan"
        case _ => "STOP"
    }
}
