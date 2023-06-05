package tavern

fun main(args: Array<String>) {
    var beverage = readLine()
    beverage?.let {
        if(it.isNotEmpty()) {
            beverage = it.replaceFirstChar { it.uppercase() }
        }else {
            println("Input is empty")
        }
    } ?: println("I can't do that without crashing - beverage was null!")
}