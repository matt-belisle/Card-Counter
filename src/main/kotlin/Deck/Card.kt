package Deck
enum class Suit { DIAMONDS, HEARTS, CLUBS, SPADES}
enum class Value(val value: Int) { ACE(1), TWO(2), THREE(3), FOUR(4),
    FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10),
    JACK(11), QUEEN(12), KING(13);
    fun get(value: Int): Value
    {
        return when(value){
            1 -> ACE
            2 -> TWO
            3 -> THREE
            4 -> FOUR
            5 -> FIVE
            6 -> SIX
            7 -> SEVEN
            8 -> EIGHT
            9 -> NINE
            10 -> TEN
            11 -> JACK
            12 -> QUEEN
            13 -> KING
            // possible bug, would rather just throw error but not going to as no way to get this just recognize a king is the end
            else -> throw Exception("Tried to increment past King")
        }
    }

}
class Card {
    val suit: Suit
    val value: Value

    constructor(suit: Suit, value: Value) {
        this.suit = suit
        this.value = value
    }

    // standard naming system 9D = 9 of diamonds
    constructor(str:String){
        assert(str.length == 2 || str.length == 3)
        val cap = str.toUpperCase()
        val valueStr = cap.dropLast(1)
        val suitStr = cap.last()
        this.value = when(valueStr){
            "1" -> Value.ACE
            "2" -> Value.TWO
            "3" -> Value.THREE
            "4" -> Value.FOUR
            "5" -> Value.FIVE
            "6" -> Value.SIX
            "7" -> Value.SEVEN
            "8" -> Value.EIGHT
            "9" -> Value.NINE
            "10" -> Value.TEN
            "J" -> Value.JACK
            "Q" -> Value.QUEEN
            "K" -> Value.KING
            else -> throw Exception("Illegal value entered for card: entered value: $str")
        }
        this.suit = when(suitStr){
            'D' -> Suit.DIAMONDS
            'H' -> Suit.HEARTS
            'C' -> Suit.CLUBS
            'S' -> Suit.SPADES
            else -> throw Exception("Illegal suit entered for card: entered value: $str")
        }

    }

    fun getCardValue(): Int{
        return when(value){
            Value.ACE -> 1
            Value.TWO -> 2
            Value.THREE -> 3
            Value.FOUR -> 4
            Value.FIVE -> 5
            Value.SIX -> 6
            Value.SEVEN -> 7
            Value.EIGHT -> 8
            Value.NINE -> 9
            // the face cards and ten
            else -> 10
        }
    }

    override fun toString(): String {
        return "${value.name.toLowerCase().capitalize()} of ${suit.name.toLowerCase().capitalize()}"
    }

    override fun equals(other: Any?): Boolean {
        if(other is Card){
            return value == other.value && suit == other.suit
        }
        return false
    }

    override fun hashCode(): Int {
        var result = suit.hashCode()
        result = 31 * result + value.hashCode()
        return result
    }

}