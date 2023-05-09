fun main(args: Array<String>) {
    val game:Game = Game()
    val name:String = "Madrigal"
    var healthPoints:Int = 100
    var isBlessed:Boolean = true
    var auraIsVisible = isBlessed && healthPoints == 100
    val auraColor = if (auraIsVisible) "Green" else "Red"
    val healthStatus = game.formatHealthStatus(healthPoints,isBlessed)
    println(auraColor)

    println("(AuraColor: $auraColor)"+"(Blessed: ${if (isBlessed) "YES" else "NO"})")
    println("$name is in ${healthStatus}")
    var karma = when(auraColor){
        "Green" -> 5
        "Orange" -> 10
        "purple" -> 15
        "Red" -> 20
        else -> "Karma's a bitch"
    }

    game.castFireball(5)
    println(karma)
}