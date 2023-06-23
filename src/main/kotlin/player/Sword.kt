package player

class Sword(_name: String) {
    var name = _name
        get() = "The legendary $field"
        set(value){
            field = value.lowercase().reversed().uppercase();
        }

    init {
        name = _name;
    }
}