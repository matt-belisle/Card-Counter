package Rules

import Deck.Card
import Deck.Value

/*
 if the player holds a Jack which is the same suit as the turned up card,
  this is called his nob, and scores the player an additional 1 point.
 */
object Nob : Rule() {
    override fun parse(hand: List<Card>, flippedCard: Card): Int {
        super.parse(hand, flippedCard)
        val nibCard = Card(flippedCard.suit, Value.JACK)
        return if (hand.contains(nibCard)) 1 else 0
    }
}