package tavern

fun main(args: Array<String>) {
    var swordsJuggling: Int? = null
    val isJugglingProficient = (1..3).shuffled().last() == 3
    if (isJugglingProficient) {
        swordsJuggling = 2
    }
    try {
        proficiencyCheck(swordsJuggling)
        swordsJuggling = swordsJuggling!!.plus(1)
    } catch (e : Exception){
        println("This is the exception $e")
    }
    println("You juggle $swordsJuggling swords!")

}

fun proficiencyCheck(swordsJuggling: Int?){
    swordsJuggling ?: throw UnSkilledSwordJugglerException()
}

class UnSkilledSwordJugglerException() : IllegalStateException("Player cannot juggle swords")