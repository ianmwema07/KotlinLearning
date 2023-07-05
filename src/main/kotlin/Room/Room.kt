package Room

import Interfaces.Goblin
import Interfaces.Monster

open class Room(val name: String) {
    protected open val dangerLevel = 5;
    var monster: Monster? = Goblin()
    fun description() = "Room $name\n Danger level is $dangerLevel\n" + "Creature : ${monster?.description ?: "none ."}";

    open fun load() = "Nothing  much to see here ...";
}

