package ProblemThreeCardsWithPower;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rank = scanner.nextLine();
        String suit = scanner.nextLine();

        CardRanks cardRank = CardRanks.valueOf(rank);
        CardSuits cardSuit = CardSuits.valueOf(suit);
        Card card = new Card(cardSuit, cardRank);
        System.out.printf("Card name: %s of %s; Card power: %d%n", cardRank, cardSuit, card.getPower());
    }
}
