package ProblemFourPizzaCalories;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] pizzaInfo = scanner.nextLine().split(" ");

        try {
            String pizzaName = pizzaInfo[1];
            int numOfToppings = Integer.parseInt(pizzaInfo[2]);
            Pizza pizza = new Pizza(pizzaName, numOfToppings);

            String[] doughInfo = scanner.nextLine().split(" ");
            String flourType = doughInfo[1];
            String bakingTechnique = doughInfo[2];
            double doughWeight = Double.parseDouble(doughInfo[3]);
            Dough dough = new Dough(flourType, bakingTechnique, doughWeight);

            pizza.setDough(dough);

            String command = scanner.nextLine();

            while (!command.equals("END")) {
                String toppingType = command.split("\\s+")[1];
                double toppingWeight = Double.parseDouble(command.split("\\s+")[2]);
                Topping topping = new Topping(toppingType, toppingWeight);
                pizza.addTopping(topping);

                command = scanner.nextLine();
            }

            System.out.printf("%s - %.2f%n", pizzaName, pizza.getOverallCalories());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (ArrayIndexOutOfBoundsException p) {
            System.out.println("Number of toppings should be in range [0..10].");
        }
    }
}
