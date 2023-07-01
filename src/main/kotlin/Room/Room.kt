package Room

open class Room(val name: String) {
    protected open val dangerLevel = 5;
    fun description() = "Room $name\n Danger level is $dangerLevel";

    open fun load() = "Nothing  much to see here ...";
}

