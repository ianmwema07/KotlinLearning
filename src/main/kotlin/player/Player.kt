package player

import Interfaces.Fightable
import Room.Coordinate
import java.io.File

class Player(_name: String, override var healthPoints: Int, _isBlessed: Boolean, _isImmortal: Boolean) : Fightable {

    var homeTown = selectHomeTown();
    var name = _name
    get() = "${field.uppercase()} of $homeTown"
    private set(value) {
            field = value.trim()
        }

    var currentPosition = Coordinate(0, 0)

    private fun selectHomeTown() = File("data/towns.csv")
        .readText()
        .split(',')
        .first()


    override var diceCount = 3

    //        get() = TODO("Not yet implemented")
//        set(value) {}
    override val diceSides = 6
//        get() = TODO("Not yet implemented")
    override val damageRoll: Int
        get() = TODO("Not yet implemented")

    override fun attack(opponent: Fightable): Int {
        val damageDealt = if (isBlessed) {
            damageRoll * 2
        } else {
            damageRoll
        }
        opponent.healthPoints -= damageDealt
        return damageDealt
    }

    val isBlessed = _isBlessed;
    private val isImmortal = _isImmortal;
    fun castFireBall(numFireballs: Int=2){
        println("A glass of fireball springs to existence. (x$numFireballs)")
    }

    fun auraColor(): String {
        return "red";
    }

    public fun formatHealthStatus(healthPoints:Int, isBlessed:Boolean) = when (healthPoints) {
        100 -> "is in good condition"
        in 90..99 -> "Condition is improving"
        in 80..89 -> "condition could get better"
        else -> "awful condition"
    }

    class Dice() {

    }
}