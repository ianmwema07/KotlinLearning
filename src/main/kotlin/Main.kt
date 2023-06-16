import JavaFiles.JavaCode
import player.Player

fun main(args: Array<String>) {
    val game:Game = Game()

    val player = Player();
    var auraIsVisible = player.isBlessed && player.healthPoints == 100
    val auraColor = if (auraIsVisible) "Green" else "Red"
    val healthStatus = game.formatHealthStatus(player.healthPoints,player.isBlessed)
    val javaCode : JavaCode = JavaCode();
    println(auraColor)
    player.castFireBall()

    println("(AuraColor: $auraColor)"+"(Blessed: ${if (player.isBlessed) "YES" else "NO"})")
    println("${player.name} is in ${healthStatus}")
    javaCode.helloThere()
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