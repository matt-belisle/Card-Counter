package Rules

import Deck.Card
import Deck.Suit
import Deck.Value
import org.junit.Assert.*
import org.junit.Test

class NibsTest{
    @Test
    fun hasIt(){
        assertEquals(1,Nibs.parse(listOf(
            Card(Suit.DIAMONDS, Value.JACK),
            Card(Suit.SPADES, Value.TWO),
            Card(Suit.HEARTS, Value.ACE),
            Card(Suit.CLUBS, Value.ACE)
        ),
            Card(Suit.DIAMONDS, Value.ACE)
        ))
    }
    @Test
    fun doesNotHaveIt(){
        assertEquals(0,Nibs.parse(listOf(
            Card(Suit.DIAMONDS, Value.JACK),
            Card(Suit.SPADES, Value.TWO),
            Card(Suit.HEARTS, Value.ACE),
            Card(Suit.CLUBS, Value.ACE)
        ),
            Card(Suit.SPADES, Value.ACE)
        ))
    }


}