package variance

import Generics.Coin
import Generics.Fedora
import Generics.Loot

class Barrel<T>(var item: T)
fun main(args: Array<String>) {
    var fedoraBarrel: Barrel<Fedora> = Barrel(Fedora("a generic-looking fedora", 15))
    var lootBarrel: Barrel<Loot> = Barrel(Coin(15))
}