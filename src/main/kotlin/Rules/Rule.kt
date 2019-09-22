package Rules

import Deck.Card

// represents a single rule of the game of cribbage
// run a hand through all rules to determine its score
// returns the value of the hand under that rule

abstract class Rule {
    open fun parse (hand : List<Card>, flippedCard: Card): Int{
        assert(hand.size == 4)
        return 0
    }
}