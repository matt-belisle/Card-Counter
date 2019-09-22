package Rules

import Deck.Card
import Deck.Suit
import Deck.Value
import org.junit.Assert.*
import org.junit.Test

class RunTest{
    @Test
    fun runOfThree(){
        assertEquals(3,Run.parse(listOf(
            Card(Suit.DIAMONDS, Value.TWO),
            Card(Suit.SPADES, Value.THREE),
            Card(Suit.HEARTS, Value.ACE),
            Card(Suit.CLUBS, Value.KING)
        ),
            Card(Suit.DIAMONDS, Value.TEN)
        ))
    }
    @Test
    fun runOfThree_OneDup(){
        assertEquals(6,Run.parse(listOf(
            Card(Suit.DIAMONDS, Value.TWO),
            Card(Suit.SPADES, Value.THREE),
            Card(Suit.HEARTS, Value.ACE),
            Card(Suit.CLUBS, Value.TWO)
        ),
            Card(Suit.DIAMONDS, Value.TEN)
        ))
    }
    @Test
    fun runOfThree_ThreeOfAKind(){
        assertEquals(9,Run.parse(listOf(
            Card(Suit.DIAMONDS, Value.TWO),
            Card(Suit.SPADES, Value.THREE),
            Card(Suit.HEARTS, Value.ACE),
            Card(Suit.CLUBS, Value.TWO)
        ),
            Card(Suit.DIAMONDS, Value.TWO)
        ))
    }
    @Test
    fun runOfThree_TwoDup(){
        assertEquals(12,Run.parse(listOf(
            Card(Suit.DIAMONDS, Value.TWO),
            Card(Suit.SPADES, Value.THREE),
            Card(Suit.HEARTS, Value.ACE),
            Card(Suit.CLUBS, Value.ACE)
        ),
            Card(Suit.DIAMONDS, Value.TWO)
        ))
    }
    @Test
    fun runOfFour(){
        assertEquals(4,Run.parse(listOf(
            Card(Suit.DIAMONDS, Value.TWO),
            Card(Suit.SPADES, Value.THREE),
            Card(Suit.HEARTS, Value.ACE),
            Card(Suit.CLUBS, Value.FOUR)
        ),
            Card(Suit.DIAMONDS, Value.TEN)
        ))
    }
    @Test
    fun runOfFive(){
        assertEquals(5,Run.parse(listOf(
            Card(Suit.DIAMONDS, Value.TWO),
            Card(Suit.SPADES, Value.THREE),
            Card(Suit.HEARTS, Value.ACE),
            Card(Suit.CLUBS, Value.FOUR)
        ),
            Card(Suit.DIAMONDS, Value.FIVE)
        ))
    }
}