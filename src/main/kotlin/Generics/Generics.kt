package Generics

class LootBox<T>(vararg item: T) {
    var open = false
    private var loot: Array<out T> = item

    fun fetch(item: Int) : T? {
        return loot[item].takeIf { open }
    }
    fun <R> fetch(item: Int, lootModFunction: (T) -> R): R? {
        return lootModFunction(loot[item]).takeIf { open }
    }

    operator fun get(index: Int): T? = loot[index].takeIf { open }

}

class Fedora(val name: String, val value: Int)
class Coin(override val value: Int) : Loot(1)

open class Loot(open val value: Int)
fun main(args: Array<String>) {
    val lootBoxOne: LootBox<Fedora> = LootBox(Fedora("a generic-looking fedora", 15), Fedora("a dazzling magenta Fedora", 25), Fedora("Third Position", 67))
    val lootBoxTwo: LootBox<Coin> = LootBox(Coin(15))
    lootBoxOne.open = true
    lootBoxOne.fetch(2)?.run {
        println("You retrieve a $name from the Box")
    }
    val coin = lootBoxOne.fetch(0) {
        Coin(it.value * 3)
    }
    coin?.let { println(it.value) }

    val fedora = lootBoxOne[1]
    fedora?.let { println(it.name) }
   
}