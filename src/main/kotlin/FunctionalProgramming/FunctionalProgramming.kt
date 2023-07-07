package FunctionalProgramming

val animals = listOf("zebra", "giraffe", "elephant", "rat")
val babies = animals
    .map{ animal -> "A baby $animal" }
    .map{ baby -> "$baby, with the cutest little tail ever!"}
fun main(args: Array<String>) {
    println(babies)
}