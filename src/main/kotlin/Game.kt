import Interfaces.Monster
import Room.Direction
import Room.Room
import Room.TownSquare
import player.Player
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    Game.game.play()
}
class Game{
    fun castFireball(numFireBalls:Int = 2){
        println("A glass of fireball springs to existence {$numFireBalls}")
    }
    object game{
        private val player = Player("Madrigal", 2, true, true)
        private var currentRoom: Room = TownSquare()
        private var worldMap = listOf(
            listOf(currentRoom, Room("Tavern"),Room("BackRoom")),
            listOf(Room("Long Corridor"), Room("Room"))
        )

        fun play(){
            while (true){
                //Play Nyethack
                println(currentRoom.description())
                println(currentRoom.load())
                println(GameInput(readln()).processCommand())
            }
        }

        private fun move(directionInput: String) =
            try {
                val direction = Direction.valueOf(directionInput.toUpperCase())
                val newPosition = direction.updateCoordinate(player.currentPosition)


            } catch (e: Exception) {
                "Invalid direction: $directionInput."
            }

        private fun fight() = currentRoom.monster?.let {
            while (player.healthPoints > 0 && it.healthPoints > 0){
                slay(it)
                Thread.sleep(10000)
            }
            "Combat complete"
        } ?: "There is nothing here to fight"

        private fun slay(monster: Monster) {
            println("${monster.name} did ${monster.attack(player)} damage!")
            println("${player.name} did ${player.attack(monster)} damage!")
            if (player.healthPoints <= 0) {
                println(">>>> You have been defeated! Thanks for playing. <<<<")
                exitProcess(0)
                exitProcess(0)
            }
        }

        private class GameInput(arg: String?){
            private val input = arg ?: ""
            val command = input.split("")[0]
            val argument = input.split("").getOrElse(1,{""})
            fun processCommand() = when (command.lowercase()){
                "fight"-> fight()
                "move" -> move(argument)
                else -> commandNotFound()
            }
            private fun commandNotFound() = "I'm not quite sure what you're trying to do!"
        }
        init {
            println("Welcome Adventurer")
            player.castFireBall(7)
        }

        private fun printPlayerStatus(player: Player) {
            println("(Aura: ${player.auraColor()}) " +
                    "(Blessed: ${if (player.isBlessed) "YES" else "NO"})")
            println("${player.name} ${player.formatHealthStatus(10,true)}")
        }
    }
}


