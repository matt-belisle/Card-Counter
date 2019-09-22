package Rules

import Deck.Card
import Deck.Suit
import Deck.Value
import org.junit.Assert.*
import org.junit.Test

class FlushTest{
    @Test
    fun noFlush(){
        assertEquals(0,Flush.parse(listOf(
            Card(Suit.DIAMONDS, Value.JACK),
            Card(Suit.SPADES, Value.TWO),
            Card(Suit.HEARTS, Value.ACE),
            Card(Suit.CLUBS, Value.ACE)
        ),
            Card(Suit.SPADES, Value.ACE)
        ))
    }

    @Test
    fun flushNoFlippedCard(){
        assertEquals(4,Flush.parse(listOf(
            Card(Suit.DIAMONDS, Value.JACK),
            Card(Suit.DIAMONDS, Value.TWO),
            Card(Suit.DIAMONDS, Value.ACE),
            Card(Suit.DIAMONDS, Value.ACE)
        ),
            Card(Suit.SPADES, Value.ACE)
        ))
    }
    @Test
    fun flushWithFlippedCard(){
        assertEquals(5,Flush.parse(listOf(
            Card(Suit.DIAMONDS, Value.JACK),
            Card(Suit.DIAMONDS, Value.TWO),
            Card(Suit.DIAMONDS, Value.ACE),
            Card(Suit.DIAMONDS, Value.ACE)
        ),
            Card(Suit.DIAMONDS, Value.ACE)
        ))
    }
    @Test
    fun onlyThreeDontIncludeFlip(){
        assertEquals(0,Flush.parse(listOf(
            Card(Suit.DIAMONDS, Value.JACK),
            Card(Suit.DIAMONDS, Value.TWO),
            Card(Suit.DIAMONDS, Value.ACE),
            Card(Suit.SPADES, Value.ACE)
        ),
            Card(Suit.DIAMONDS, Value.ACE)
        ))
    }
}