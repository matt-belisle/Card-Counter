package Rules

import Deck.Card
import Deck.Suit
import Deck.Value
import org.junit.Assert.*
import org.junit.Test


class PairTest{

    @Test
    fun singlePair(){
        assertEquals(2,Pair.parse(listOf(Card(Suit.DIAMONDS, Value.TWO),
            Card(Suit.SPADES, Value.TWO),
            Card(Suit.DIAMONDS, Value.SEVEN),
            Card(Suit.DIAMONDS, Value.TEN)),
            Card(Suit.DIAMONDS, Value.ACE)))
    }

    @Test
    fun threeOfAKind(){
        assertEquals(6,Pair.parse(listOf(Card(Suit.DIAMONDS, Value.TWO),
            Card(Suit.SPADES, Value.TWO),
            Card(Suit.HEARTS, Value.TWO),
            Card(Suit.DIAMONDS, Value.TEN)),
            Card(Suit.DIAMONDS, Value.ACE)))
    }

    @Test
    fun fourOfAKind(){
        assertEquals(12,Pair.parse(listOf(Card(Suit.DIAMONDS, Value.TWO),
            Card(Suit.SPADES, Value.TWO),
            Card(Suit.HEARTS, Value.TWO),
            Card(Suit.CLUBS, Value.TWO)),
            Card(Suit.DIAMONDS, Value.ACE)))
    }

    @Test
    fun noMatch(){
        assertEquals(0,Pair.parse(listOf(Card(Suit.DIAMONDS, Value.TWO),
            Card(Suit.SPADES, Value.THREE),
            Card(Suit.HEARTS, Value.FOUR),
            Card(Suit.CLUBS, Value.FIVE)),
            Card(Suit.DIAMONDS, Value.ACE)))
    }

    @Test
    fun twoPair(){
        assertEquals(4,Pair.parse(listOf(Card(Suit.DIAMONDS, Value.TWO),
            Card(Suit.SPADES, Value.TWO),
            Card(Suit.HEARTS, Value.ACE),
            Card(Suit.CLUBS, Value.FOUR)),
            Card(Suit.DIAMONDS, Value.ACE)))
    }

    @Test
    fun pairThreeofAKind(){
        assertEquals(8,Pair.parse(listOf(Card(Suit.DIAMONDS, Value.TWO),
            Card(Suit.SPADES, Value.TWO),
            Card(Suit.HEARTS, Value.ACE),
            Card(Suit.CLUBS, Value.ACE)),
            Card(Suit.DIAMONDS, Value.ACE)))
    }
}