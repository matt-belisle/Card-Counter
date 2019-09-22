package Rules

import Deck.Card

/*
Any combination of cards that add up fifteen pips, scores 2 points (in counting pips,
all face cards count as ten, and the Ace always counts as one).
The fifteen count can be made using two, three, four, or all five of the cards.
Each distinct combination of cards that add up to fifteen score two points.
 */

object Fifteen : Rule() {
    // this will just be brute forced, there's only 30 possible combinations that work of 5 cards cards so its not a big deal
    override fun parse(hand: List<Card>, flippedCard: Card): Int {
        super.parse(hand, flippedCard)
        val cards = hand.toMutableList()
        cards.add(flippedCard)
        var matched = 0

        // start at 3 as first time with two cards

        for (i in 3..31) {
            var repitition = i
            var location = 0
            var count = 0
            do {
                if (repitition and 1 == 1) {
                    count += cards[location].getCardValue()
                }
                // quit early if you can
                if(count > 15){
                    break
                }
                repitition = repitition.shr(1)
                location++
            } while (repitition > 0)
            if (count == 15) {
                matched++
            }
        }
        return matched * 2
    }
}