package WildFarm;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<Animal> animals = new ArrayList<>();

        while (!input.equals("End")) {
            Animal animal = getAnimal(input);
            animals.add(animal);
            String[] foodInfo = scanner.nextLine().split("\\s+");
            Food food = getFood(foodInfo);

            animal.makeSound();

            try {
                animal.eat(food);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
            input = scanner.nextLine();
        }
        animals.forEach(animal -> System.out.println(animal.toString()));
    }

    private static Food getFood(String[] foodInfo) {
        String foodType = foodInfo[0];
        int foodQuantity = Integer.parseInt(foodInfo[1]);

        if (foodType.equals("Meat")) {
            return new Meat(foodQuantity);
        } else {
            return new Vegetable(foodQuantity);
        }
    }

    private static Animal getAnimal(String input) {
        String[] animalInfo = input.split("\\s+");
        String type = animalInfo[0];
        String name = animalInfo[1];
        double weight = Double.parseDouble(animalInfo[2]);
        String livingRegion = animalInfo[3];

        switch (type) {
            case "Cat":
                String breed = animalInfo[4];
                return new Cat(name, type, weight, livingRegion, breed);
            case "Mouse":
                return new Mouse(name, type, weight, livingRegion);
            case "Tiger":
                return new Tiger(name, type, weight, livingRegion);
            case "Zebra":
                return new Zebra(name, type, weight, livingRegion);
            default:
                throw new IllegalArgumentException("No such animal");
        }
    }
}
