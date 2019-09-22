package Rules

import Deck.Card
import Deck.Value

// represents the rule to detect all pairs, threes of a king, four of a kind in a hand
// 2 points per pair
// 6 points per three of a kind (as it is 3 different pairs)
// 12 points per four of a kind (as it is 4 different pairs)
object Pair : Rule() {
    override fun parse(hand: List<Card>, flippedCard: Card): Int {
        super.parse(hand, flippedCard)

      val occurences = toIntMap(hand, flippedCard)

        return occurences.values.fold(0, { acc, value ->
            acc +
                    when (value) {
                        2 -> 2
                        3 -> 6
                        4 -> 12
                        else -> 0
                    }
        })
    }
}
