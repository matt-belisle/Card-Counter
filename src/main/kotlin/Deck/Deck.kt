package Deck

import java.util.*

class Deck{
    val cards: List<Card>
    private constructor(cards: List<Card>){
        this.cards = cards
    }
    // returns a new deck that is shuffled
    fun shuffle(): Deck {
        val shuffled  = cards.toMutableList().shuffled(Random())
        shuffled.forEach { println(it) }
        return Deck(shuffled)
    }
    companion object{
        //creates a normal 52 card playing card deck
        fun createBasicDeck(): Deck{
            val cards = mutableListOf<Card>()
            for (suit in Suit.values()){
                for(value in Value.values()){
                    cards.add(Card(suit,value))
                }
            }
            return Deck(cards)
        }
    }
}

