package ProblemOne;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Buyer> buyers = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] tokens = input.split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            String id = "";
            String birthDate = "";
            String groupName = "";
            if (tokens.length > 3) {
                id = tokens[2];
                birthDate = tokens[3];
                Citizen citizen = new Citizen(name, age, id, birthDate);
                if (!checkNameExists(buyers, name)) {
                    buyers.put(name, citizen);
                }
            } else {
                groupName = tokens[2];
                Rebel rebel = new Rebel(name, age, groupName);
                if (!checkNameExists(buyers, name)) {
                    buyers.put(name, rebel);
                }
            }
        }
        String buyerName = scanner.nextLine();

        while (!buyerName.equals("End")) {
            if (!buyers.containsKey(buyerName)) {
                buyerName = scanner.nextLine();
                continue;
            }
            buyers.get(buyerName).buyFood();
            buyerName = scanner.nextLine();
        }

        int sumFood = 0;
        for (Buyer buyer : buyers.values()) {
            sumFood += buyer.getFood();
        }

        System.out.println(sumFood);
    }

    private static boolean checkNameExists(Map<String, Buyer> buyers, String name) {
        if (buyers.containsKey(name)) {
            return true;
        }
        return false;
    }
}
