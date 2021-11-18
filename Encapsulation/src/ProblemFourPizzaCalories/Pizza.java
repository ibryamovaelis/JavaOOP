package ProblemFourPizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private int numOfToppings;
    private List<Topping> toppings;

    public Pizza(String name, int numOfToppings) {
        this.setName(name);
        this.setToppings(numOfToppings);
        this.toppings = new ArrayList<>();
    }

    private void setName(String name) {
        if (name.trim().isEmpty() || name.length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    private void setToppings(int numOfToppings) {
        if (numOfToppings < 0 || numOfToppings > 10) {
            throw new ArrayIndexOutOfBoundsException("Number of toppings should be in range [0..10].");
        }
        this.numOfToppings = numOfToppings;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public String getName() {
        return name;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public double getOverallCalories() {
        double sumToppingCalories = 0;
        for (Topping topping : toppings) {
            sumToppingCalories += topping.calculateCalories();
        }
        return dough.calculateCalories() + sumToppingCalories;
    }
}
