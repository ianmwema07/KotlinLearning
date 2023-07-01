import Room.Direction
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

        private var worldMap = listOf(
            listOf(currentRoom, Room("Tavern"),Room("BackRoom")),
            listOf(Room("Long Corridor"), Room("Room"))
        )

        private fun move(directionInput: String) =
            try {
                val direction = Direction.valueOf(directionInput.toUpperCase())
                val newPosition = direction.updateCoordinate(player.currentPosition)


                } catch (e: Exception) {
                    "Invalid direction: $directionInput."
                }

        private class GameInput(arg: String?){
            private val input = arg ?: ""
            val command = input.split("")[0]
            val argument = input.split("").getOrElse(1,{""})
            fun processCommand() = when (command.lowercase()){
                else -> commandNotFound()
            }
            private fun commandNotFound() = "I'm not quite sure what you're trying to do!"
        }
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