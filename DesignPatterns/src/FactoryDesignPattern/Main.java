package FactoryDesignPattern;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pizzaType = scanner.nextLine();
        PizzaFactory pizzaFactory = new PizzaFactory();
        Pizzeria pizzeria = new Pizzeria(pizzaFactory);
        pizzeria.orderPizza("Bulgarian", 45);
    }
}
