package Rules

import Deck.Card
import Deck.Value

// represents a single rule of the game of cribbage
// run a hand through all rules to determine its score
// returns the value of the hand under that rule

abstract class Rule {
    open fun parse (hand : List<Card>, flippedCard: Card): Int{
        assert(hand.size == 4)
        return 0
    }
    internal fun toIntMap(hand : List<Card>, flippedCard: Card): Map<Value, Int>{
        val map = mutableMapOf<Value, Int>()
        hand.forEach { map[it.value] = map[it.value]?.inc() ?: 1 }
        map[flippedCard.value] = map[flippedCard.value]?.inc() ?: 1
        return map
    }
}