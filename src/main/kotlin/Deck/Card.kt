package Deck
enum class Suit { DIAMONDS, HEARTS, CLUBS, SPADES}
enum class Value { ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING}
class Card (val suit: Suit, val value: Value){

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
            val otherCard = other as Card
            return value == otherCard.value && suit == otherCard.suit
        }
        return false
    }

}