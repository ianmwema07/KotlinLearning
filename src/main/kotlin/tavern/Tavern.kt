package tavern

import java.io.File


const val TAVERN_NAME = "Taernyl's Folly"
var playerGold = 10
var playerSilver = 10
val patronList = mutableListOf("Eli", "Mod-ric", "Sophie")
val lastName = listOf("Ironfoot", "Fernsworth", "Baggins")
val uniquePatrons = mutableSetOf<String>()
val menuList = File("data/tavern-menu-data.txt")
                    .readText()
                    .split("\n")
val planets = setOf("Mercury", "Venus", "Earth")


fun main(args: Array<String>) {
    println(patronList)
    patronList.remove("Eli")
    patronList.add("Alex")
    patronList.add(0,"Alex")
    println("This is the new patron list $patronList")
    patronList.forEach {
        patron -> println("Good morning $patron")
        placeOrder(patron, menuList.shuffled().first())

    }
    menuList.forEachIndexed { index, data ->
        var drinkInfo = data.split(',')
        println("$drinkInfo[1] ..................$drinkInfo[2]")
    }
    (0..9).forEach {
        val first = patronList.shuffled().first();
        val last = lastName.shuffled().first()
        val name = "$first $last"
        uniquePatrons += name
    }
    println(uniquePatrons)
}


private fun toDragonSpeak(phrase: String) =
    phrase.replace(Regex("[aeiou]")) {
        when (it.value) {
            "a"  -> "4"
            "e" -> "3"
            "i" -> "1"
            "o" -> "0"
            "u" -> "|_|"
            else -> it.value
        }
    }

private fun placeOrder(menuData: String, menuItem: String){
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("Madrigal speaks with $tavernMaster about their order. $menuItem")
    performPurchase()
    val data = menuData.split(',')
    val type = data[0]
}

fun performPurchase() {
    displayBalance()
}
private fun displayBalance() {
    println("Player's purse balance: Gold: $playerGold , Silver: $playerSilver")
}



