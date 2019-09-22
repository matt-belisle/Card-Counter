import Deck.Card
import Deck.Suit
import Deck.Value
import Rules.Fifteen
import org.junit.Assert.*
import org.junit.Test

class ScoreCalculatorTest {
    @Test
    fun pairAndFifteen() {
        assertEquals(
            4, ScoreCalculator.calculateCribbageScore(
                listOf(
                    Card(Suit.DIAMONDS, Value.TWO),
                    Card(Suit.SPADES, Value.TWO),
                    Card(Suit.DIAMONDS, Value.FIVE),
                    Card(Suit.DIAMONDS, Value.TEN)
                ),
                Card(Suit.DIAMONDS, Value.NINE)
            )
        )
    }

    @Test
    fun fourFifteenTwoPair() {
        assertEquals(
            12, ScoreCalculator.calculateCribbageScore(
                listOf(
                    Card(Suit.DIAMONDS, Value.FIVE),
                    Card(Suit.SPADES, Value.FIVE),
                    Card(Suit.HEARTS, Value.TEN),
                    Card(Suit.DIAMONDS, Value.TEN)
                ),
                Card(Suit.DIAMONDS, Value.ACE)
            )
        )
    }

    @Test
    fun threeFifteen() {
        assertEquals(
            7, ScoreCalculator.calculateCribbageScore(
                listOf(
                    Card(Suit.DIAMONDS, Value.TWO),
                    Card(Suit.SPADES, Value.THREE),
                    Card(Suit.HEARTS, Value.ACE),
                    Card(Suit.CLUBS, Value.FOUR)
                ),
                Card(Suit.DIAMONDS, Value.FIVE)
            )
        )
    }


    @Test
    fun bestHand() {
        assertEquals(
            29, ScoreCalculator.calculateCribbageScore(
                listOf(
                    Card(Suit.DIAMONDS, Value.JACK),
                    Card(Suit.SPADES, Value.FIVE),
                    Card(Suit.HEARTS, Value.FIVE),
                    Card(Suit.CLUBS, Value.FIVE)
                ),
                Card(Suit.DIAMONDS, Value.FIVE)
            )
        )
    }
}
