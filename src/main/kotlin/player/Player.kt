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

    class Dice() {

    }
}