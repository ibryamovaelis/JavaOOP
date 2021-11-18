package greedyTimes;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Bag {
    private long capacity;
    private Map<String, Gem> gems;
    private Map<String, Cash> cash;
    private Map<String, Gold> gold;
//    private Gold gold;

    public Bag(long capacity) {
        this.capacity = capacity;
        this.gems = new LinkedHashMap<>();
        this.cash = new LinkedHashMap<>();
        this.gold = new HashMap<>();
//        this.gold = new Gold();
    }

    public boolean checkCapacityOfBag(long itemQuantity) {
        return capacity <
                (itemQuantity
                + getTreasureAmount("Gem")
                + getTreasureAmount("Cash")
                + getTreasureAmount("Gold"));
    }

    public long getTreasureAmount(String treasure) {
        long totalQuantity = 0;
        switch (treasure) {
            case "Gem":
                for (Gem gem : gems.values()) {
                    totalQuantity += gem.getQuantity();
                }
                break;
            case "Gold":
                for (Gold gold : this.gold.values()) {
                    totalQuantity += gold.getQuantity();
                }
//                totalQuantity = gold.getQuantity();
                break;
            case "Cash":
                for (Cash cash : cash.values()) {
                    totalQuantity += cash.getQuantity();
                }
                break;
        }
        return totalQuantity;
    }

    public void addTreasureToBag(String treasureType, String treasureToAdd, int itemQuantity) {
        switch (treasureType) {
            case "Gem":
                if (getTreasureAmount("Gold") >= (itemQuantity + getTreasureAmount("Gem")) &&
                        (itemQuantity + getTreasureAmount("Gem")) >= getTreasureAmount("Cash")) {
                    if (gems.containsKey(treasureToAdd)) {
                        gems.put(treasureToAdd, new Gem(treasureToAdd,
                                itemQuantity + this.gems.get(treasureToAdd).getQuantity()));
                    } else {
                        Gem gem = new Gem(treasureToAdd, itemQuantity);
                        this.gems.put(treasureToAdd, gem);
                    }
                }
                break;
            case "Cash":
                if ((getTreasureAmount("Cash") + itemQuantity) <= getTreasureAmount("Gem")) {
                    if (cash.containsKey(treasureToAdd)) {
                        cash.put(treasureToAdd, new Cash(treasureToAdd,
                                itemQuantity + this.cash.get(treasureToAdd).getQuantity()));
                    } else {
                        Cash cash = new Cash(treasureToAdd, itemQuantity);
                        this.cash.put(treasureToAdd, cash);
                    }
                }
                break;
            case "Gold":
                if ((getTreasureAmount("Gold") + itemQuantity) >= getTreasureAmount("Gem")) {
                    if (gold.containsKey("Gold")) {
                        gold.put("Gold", new Gold(itemQuantity + this.gold.get("Gold").getQuantity()));
//                    gold.setQuantity(itemQuantity + gold.getQuantity());
                    } else {
                        Gold gold = new Gold (itemQuantity);
                        this.gold.put("Gold", gold);
                    }
                }
                break;
        }
    }

    public void printOutput() {
        if (!gold.isEmpty()) {
            System.out.println("<Gold> $" + getTreasureAmount("Gold"));
            System.out.println("##Gold - " + getTreasureAmount("Gold"));

            long totalGem = getTreasureAmount("Gem");
            long totalCash = getTreasureAmount("Cash");

            if (!gems.isEmpty()) {
                System.out.println("<Gem> $" + totalGem);
                gems.values()
                        .stream()
                        .sorted((e1, e2) -> e2.getName().compareTo(e1.getName()))
                        .forEach(i -> System.out.println("##" + i.getName() + " - " + i.getQuantity()));

                if (!cash.isEmpty()) {
                    System.out.println("<Cash> $" + totalCash);
                    cash.values()
                            .stream()
                            .sorted((e1, e2) -> e2.getName().compareTo(e1.getName()))
                            .forEach(i -> System.out.println("##" + i.getName() + " - " + i.getQuantity()));
                }
            }
        }
    }
}
