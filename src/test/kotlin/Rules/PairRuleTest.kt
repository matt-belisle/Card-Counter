package Rules

import Deck.Card
import Deck.Suit
import Deck.Value
import org.junit.Assert.*
import org.junit.Test


class PairRuleTest{

    @Test
    fun singlePairRule(){
        assertEquals(2,PairRule.parse(listOf(Card(Suit.DIAMONDS, Value.TWO),
            Card(Suit.SPADES, Value.TWO),
            Card(Suit.DIAMONDS, Value.SEVEN),
            Card(Suit.DIAMONDS, Value.TEN)),
            Card(Suit.DIAMONDS, Value.ACE)))
    }

    @Test
    fun threeOfAKind(){
        assertEquals(6,PairRule.parse(listOf(Card(Suit.DIAMONDS, Value.TWO),
            Card(Suit.SPADES, Value.TWO),
            Card(Suit.HEARTS, Value.TWO),
            Card(Suit.DIAMONDS, Value.TEN)),
            Card(Suit.DIAMONDS, Value.ACE)))
    }

    @Test
    fun fourOfAKind(){
        assertEquals(12,PairRule.parse(listOf(Card(Suit.DIAMONDS, Value.TWO),
            Card(Suit.SPADES, Value.TWO),
            Card(Suit.HEARTS, Value.TWO),
            Card(Suit.CLUBS, Value.TWO)),
            Card(Suit.DIAMONDS, Value.ACE)))
    }

    @Test
    fun noMatch(){
        assertEquals(0,PairRule.parse(listOf(Card(Suit.DIAMONDS, Value.TWO),
            Card(Suit.SPADES, Value.THREE),
            Card(Suit.HEARTS, Value.FOUR),
            Card(Suit.CLUBS, Value.FIVE)),
            Card(Suit.DIAMONDS, Value.ACE)))
    }

    @Test
    fun twoPairRule(){
        assertEquals(4,PairRule.parse(listOf(Card(Suit.DIAMONDS, Value.TWO),
            Card(Suit.SPADES, Value.TWO),
            Card(Suit.HEARTS, Value.ACE),
            Card(Suit.CLUBS, Value.FOUR)),
            Card(Suit.DIAMONDS, Value.ACE)))
    }

    @Test
    fun pairThreeofAKind(){
        assertEquals(8,PairRule.parse(listOf(Card(Suit.DIAMONDS, Value.TWO),
            Card(Suit.SPADES, Value.TWO),
            Card(Suit.HEARTS, Value.ACE),
            Card(Suit.CLUBS, Value.ACE)),
            Card(Suit.DIAMONDS, Value.ACE)))
    }
}