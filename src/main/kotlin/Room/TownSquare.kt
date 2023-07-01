package Room

class TownSquare: Room("Town Square") {
    override val dangerLevel = super.dangerLevel - 3;
    private val bellSound = "Gwong";
    override fun load() = "The Villageres rally and cheer  as you enter!\n${ringBell()}"
    private fun ringBell()  = "The Bell tower announces arrival. $bellSound"
}