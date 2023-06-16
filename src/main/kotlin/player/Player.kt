package player

class Player {
    var healthPoints:Int = 100
    var isBlessed:Boolean = true
    var name: String = "Madrigal"
    get() = field.capitalize()
        set(value) {
            field = value.trim()
        }
    fun castFireBall(numFireballs: Int=2){
        println("A glass of fireball springs to existence. (x$numFireballs)")
    }

    class Dice() {

    }
}