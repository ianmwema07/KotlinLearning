fun main(){
    val race = "gnome"
    val faction = when(race){
        "dwarf"-> "Keepers of the mines"
        "gnome" -> "The old keepers of the mines"
        "orc" -> "Free people of the rolling hills"
        "human" -> "The most beloved"
        else -> "not a race"
    }

    println(faction)
}