import Room.Room
import Room.TownSquare
import player.Player

class Game{
    fun main(args: Array<String>) {
        Game.play()
    }


     fun castFireball(numFireBalls:Int = 2){
        println("A glass of fireball springs to existence {$numFireBalls}")
    }

    object Game{
        private val player = Player("Madrigal", 2, true, true)
        private var currentRoom: Room = TownSquare()
        init {
            println("Welcome Adventurer")
            player.castFireBall(7)
        }
        fun play(){
            while (true){
            //Play Nyethack
                println(currentRoom.description())
                println(currentRoom.load())
                printPlayerStatus(player)
            }
        }
        private fun printPlayerStatus(player: Player) {
            println("(Aura: ${player.auraColor()}) " +
                    "(Blessed: ${if (player.isBlessed) "YES" else "NO"})")
            println("${player.name} ${player.formatHealthStatus(10,true)}")
        }
    }


}