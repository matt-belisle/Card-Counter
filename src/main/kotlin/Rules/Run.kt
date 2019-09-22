package Rules

import Deck.Card
import Deck.Value

/*
A run of three consecutive cards scores 3 points. A run of four cards scores 4 points,
and all five cards in consecutive order scores 5 points.
Aces always count as one, and runs cannot go around the clock.
Every distinct run is scored.
 */
object Run : Rule() {
    override fun parse(hand: List<Card>, flippedCard: Card): Int {
        super.parse(hand, flippedCard)
        val occurrences = toIntMap(hand, flippedCard)
        val distinctCards = occurrences.keys.sorted()

        for (item in distinctCards) {
            var runLength = 0
            // multiply runCount by duplicates
            var duplicates = 1
            var currentCard = item
            var nextCard = item
            do {
                currentCard = nextCard


                runLength++
                duplicates *= (occurrences[currentCard] ?: 1)

                // end check at kings no matter what
                if (currentCard == Value.KING) {
                    break
                }
                nextCard = currentCard.get(currentCard.value + 1)
            } while (distinctCards.contains(nextCard))
            val runValue = valueOfRun(runLength, duplicates)
            if (runValue > 0) {
                // only one run can exist so as soon as one is found we can quit
                return runValue
            }
        }
        return 0
    }

    private fun valueOfRun(runLength: Int, duplicates: Int) =
        if (runLength > 2) {
            runLength * duplicates
        } else 0
}
