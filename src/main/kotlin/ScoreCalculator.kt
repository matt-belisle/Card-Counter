import Deck.Card
import Rules.*

class ScoreCalculator {
    companion object {
        fun calculateCribbageScore(hand: List<Card>, flippedCard: Card) =
            calculateScore(hand, flippedCard, listOf(Run, Flush, Fifteen, PairRule, Nob))

        private fun calculateScore(hand: List<Card>, flippedCard: Card, rules: List<Rule>) =
             rules.fold(0, { acc, rule -> acc + rule.parse(hand, flippedCard) })

    }


}