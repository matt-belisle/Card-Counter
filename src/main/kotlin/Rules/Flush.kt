package Rules

import Deck.Card
import Deck.Suit

/*
If all four cards in the players hand are the same suit, this is a called a flush and scores 4 points.
If the turned up card is also the same suit, the flush scores 5 points.
(No points are scored for a flush of four cards that comprises three in the hand with the turned up card being the same suit).
 */
object Flush : Rule() {

    override fun parse(hand: List<Card>, flippedCard: Card): Int {
        super.parse(hand, flippedCard)
        // count all suits
        var diamonds = 0
        var spades = 0
        var hearts = 0
        var clubs = 0

        hand.forEach {
            when (it.suit) {
                Suit.DIAMONDS -> diamonds++
                Suit.HEARTS -> hearts++
                Suit.CLUBS -> clubs++
                Suit.SPADES -> spades++
            }
        }
        return when {
            diamonds == 4 -> diamonds + (if (flippedCard.suit == Suit.DIAMONDS) 1 else 0)
            spades == 4 -> spades + (if (flippedCard.suit == Suit.SPADES) 1 else 0)
            hearts == 4 -> hearts + (if (flippedCard.suit == Suit.HEARTS) 1 else 0)
            clubs == 4 -> clubs + (if (flippedCard.suit == Suit.CLUBS) 1 else 0)
            else -> 0
        }

    }
}