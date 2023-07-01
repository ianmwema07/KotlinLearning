import JavaFiles.JavaCode
import Room.Room
import Room.TownSquare
import player.Player
import player.Sword

fun main(args: Array<String>) {
    var currentRoom : Room = TownSquare();
    println(currentRoom.description())
    println(currentRoom.load())
    val game:Game = Game()
    val sword = Sword("Exculibar")

    class TownSquare : Room("TownSquare");
    println("This is the sword ---> ${sword.name}");
    sword.name = "Gleipnir";
    println("${sword.name}")

    val player = Player("Madrigal",98,true,true);
    var auraIsVisible = player.isBlessed && player.healthPoints == 100
    val auraColor = if (auraIsVisible) "Green" else "Red"
    val javaCode : JavaCode = JavaCode();
    println(auraColor)
    player.castFireBall()

    println("(AuraColor: $auraColor)"+"(Blessed: ${if (player.isBlessed) "YES" else "NO"})")

    javaCode.helloThere()
    var karma = when(auraColor){
        "Green" -> 5
        "Orange" -> 10
        "purple" -> 15
        "Red" -> 20
        else -> "Karma's a bitch"
    }

    game.castFireball(5)
    game
    println(karma)
}