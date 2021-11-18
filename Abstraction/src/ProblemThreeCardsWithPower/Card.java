package ProblemThreeCardsWithPower;

public class Card {
    private CardSuits cardSuit;
    private CardRanks cardRank;

    public Card(CardSuits cardSuit, CardRanks cardRank) {
        this.cardSuit = cardSuit;
        this.cardRank = cardRank;
    }

    public int getPower() {
        return this.cardRank.getRankPower() + this.cardSuit.getSuitPower();
    }
}
