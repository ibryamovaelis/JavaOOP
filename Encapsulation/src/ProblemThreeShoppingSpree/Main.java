package ProblemThreeShoppingSpree;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Person> peopleInfo = new LinkedHashMap<>();
        Map<String, Product> productsInfo = new HashMap<>();

        String[] people = scanner.nextLine().split(";");
        for (String element : people) {
            String[] personData = element.split("=");
            String name = personData[0];
            double money = Double.parseDouble(personData[1]);

            try {
                Person person = new Person(name, money);
                peopleInfo.put(name, person);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        String[] products = scanner.nextLine().split(";");
        for (String element : products) {
            String[] productInfo = element.split("=");
            String name = productInfo[0];
            double cost = Double.parseDouble(productInfo[1]);

            try {
                Product product = new Product(name, cost);
                productsInfo.put(name, product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        String command = scanner.nextLine();
        while (!command.equals("END")) {
            String[] commandParts = command.split(" ");
            String personName = commandParts[0];
            String productName = commandParts[1];

            try {
                Person person = peopleInfo.get(personName);
                Product product = productsInfo.get(productName);
                person.buyProduct(product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            command = scanner.nextLine();
        }
        for (Person person : peopleInfo.values()) {
            System.out.print(person.getName() + " - ");
            if (person.getProducts().isEmpty()) {
                System.out.println("Nothing bought");
            } else {
                System.out.println(person.getProducts().stream()
                        .map(Product::getName)
                        .collect(Collectors.joining(", ")));
            }

        }
    }
}
