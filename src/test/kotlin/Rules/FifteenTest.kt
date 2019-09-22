package Rules

import Deck.Card
import Deck.Suit
import Deck.Value
import org.junit.Assert.*
import org.junit.Test

class FifteenTest{
    @Test
    fun singleFifteen(){
        assertEquals(2,Fifteen.parse(listOf(
            Card(Suit.DIAMONDS, Value.TWO),
            Card(Suit.SPADES, Value.TWO),
            Card(Suit.DIAMONDS, Value.FIVE),
            Card(Suit.DIAMONDS, Value.TEN)
        ),
            Card(Suit.DIAMONDS, Value.NINE)
        ))
    }

    @Test
    fun fourFifteen(){
        assertEquals(8,Fifteen.parse(listOf(
            Card(Suit.DIAMONDS, Value.FIVE),
            Card(Suit.SPADES, Value.FIVE),
            Card(Suit.HEARTS, Value.TEN),
            Card(Suit.DIAMONDS, Value.TEN)
        ),
            Card(Suit.DIAMONDS, Value.ACE)
        ))
    }

    @Test
    fun threeFifteen(){
        assertEquals(6,Fifteen.parse(listOf(
            Card(Suit.DIAMONDS, Value.EIGHT),
            Card(Suit.SPADES, Value.SEVEN),
            Card(Suit.HEARTS, Value.SEVEN),
            Card(Suit.CLUBS, Value.TEN)
        ),
            Card(Suit.DIAMONDS, Value.FIVE)
        ))
    }

    @Test
    fun noMatch(){
        assertEquals(0,Fifteen.parse(listOf(
            Card(Suit.DIAMONDS, Value.FOUR),
            Card(Suit.SPADES, Value.FOUR),
            Card(Suit.HEARTS, Value.FIVE),
            Card(Suit.CLUBS, Value.FIVE)
        ),
            Card(Suit.DIAMONDS, Value.NINE)
        ))
    }

    @Test
    fun bestHand(){
        assertEquals(16,Fifteen.parse(listOf(
            Card(Suit.DIAMONDS, Value.JACK),
            Card(Suit.SPADES, Value.FIVE),
            Card(Suit.HEARTS, Value.FIVE),
            Card(Suit.CLUBS, Value.FIVE)
        ),
            Card(Suit.DIAMONDS, Value.FIVE)
        ))
    }

}