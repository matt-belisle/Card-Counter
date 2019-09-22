import Deck.Card

fun main(args: Array<String>) {
    if (args.size != 5) {
        println("Need 5 cards to calculate a score")
        return
    }
    val hand = args.map { Card(it) }
    println("Hand is ${hand[0]}, ${hand[1]}, ${hand[2]}, ${hand[3]}, the flipped card is ${hand[4]}")
    println("The hand is worth ${ScoreCalculator.calculateCribbageScore(hand.subList(0,4), hand[4])}")
}