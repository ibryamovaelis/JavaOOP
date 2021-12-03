package FactoryDesignPattern;

public class PizzaFactory {
    public Pizza createPizza(String pizzaType, double diameter) {
        Pizza pizza = null;
        switch (pizzaType) {
            case "Bulgarian" : pizza = new BulgarianPizza(diameter);
                break;
            case "Italian": pizza = new ItalianPizza(diameter);
                break;
        }
        return pizza;
    }
}
