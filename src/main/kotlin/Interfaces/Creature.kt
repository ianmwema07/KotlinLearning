package Interfaces

interface Fightable {
    var healthPoints: Int
    var diceCount: Int
    val diceSlides: Int
    val damageRoll: Int

    fun attack(opponent: Fightable): Int
}