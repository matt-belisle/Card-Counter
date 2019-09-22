package Rules

import Deck.Card
import Deck.Value

//if the hand has a jack that is the same suit as the flipped card they get one point
class Nibs {
    companion object: Rule(){
        override fun parse(hand: List<Card>, flippedCard: Card): Int {
            super.parse(hand, flippedCard)
            val nibCard = Card(flippedCard.suit, Value.JACK)
            return if (hand.contains(nibCard)) 1 else 0
        }
    }
}