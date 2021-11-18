
package greedyTimes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long capacityBag = Long.parseLong(scanner.nextLine());
        if (capacityBag < 0) {
            return;
        }

        String[] safeContents = scanner.nextLine().split("\\s+");

        Bag bag = new Bag(capacityBag);
        for (int i = 0; i < safeContents.length; i += 2) {
            String treasureName = safeContents[i];
            String treasureType = readInputAndGetTreasureType(treasureName);
            int itemQuantity = Integer.parseInt(safeContents[i + 1]);
            if (itemQuantity < 0 || itemQuantity > 2100000000) {
                continue;
            }
            if (treasureType.equals("") || bag.checkCapacityOfBag(itemQuantity)) {
                continue;
            }
            bag.addTreasureToBag(treasureType, treasureName, itemQuantity);
        }
        bag.printOutput();
    }

    private static String readInputAndGetTreasureType(String treasureName) {
        String treasureType = "";

        if (treasureName.length() == 3) {
            treasureType = "Cash";
        } else if (treasureName.toLowerCase().endsWith("gem") && treasureName.length() >= 4) {
            treasureType = "Gem";
        } else if (treasureName.toLowerCase().equals("gold")) {
            treasureType = "Gold";
        } else return "";
        return treasureType;
    }
}