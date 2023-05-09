
class Game{
    public fun formatHealthStatus(healthPoints:Int, isBlessed:Boolean) = when (healthPoints) {
            100 -> "is in good condition"
            in 90..99 -> "Condition is improving"
            in 80..89 -> "condition could get better"
            else -> "awful condition"
        }

    public fun castFireball(numFireBalls:Int = 2){
        println("A glass of fireball springs to existence {$numFireBalls}")
    }
}