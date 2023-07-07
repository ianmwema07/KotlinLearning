package Extensions

fun String.addEnthusiasm(amount: Int = 1) = this + "!".repeat(amount)

val String.numVowels
    get() = count { "aeiou".contains(it) }


class Student(name : String, age : Int){
    var studentName : String = name;
    var studentAge : Int = age
}

var newStudent : Student = Student("Jake",12)
fun <T> T.easyPrint() : T {
    println(this)
    return this
}

fun frame(name: String, padding: Int, formatChar: String = "*"): String {
    val greeting = "$name!"
    val middle = formatChar.padEnd(padding)
        .plus(greeting)
        .plus(formatChar.padStart(padding))
    val end = (0 until middle.length).joinToString("") { formatChar }
    return "$end\n$middle\n$end"
}

infix fun String?.printWithDefault(default: String) = print(this ?: default)
fun main(args: Array<String>){
    println("Madrigal has left the building".addEnthusiasm(1))
    println("Test of the easyprint function ${newStudent.studentName.easyPrint().toString().addEnthusiasm(4).easyPrint()}")
    "How many vowels?".numVowels.easyPrint()

    val nullableString: String? = null
    nullableString printWithDefault "Default string"
}