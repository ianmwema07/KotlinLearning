package player

import java.io.File

class Player(_name: String, _healthPoints: Int, _isBlessed: Boolean, _isImmortal: Boolean) {

    var homeTown = selectHomeTown();
    var name = _name
    get() = "${field.uppercase()} of $homeTown"
    private set(value) {
            field = value.trim()
        }

    private fun selectHomeTown() = File("data/towns.csv")
        .readText()
        .split(',')
        .first()

    var healthPoints = _healthPoints;
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