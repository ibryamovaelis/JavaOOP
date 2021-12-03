package FactoryDesignPattern;

public class Pizzeria {
    PizzaFactory factory;

    public Pizzeria(PizzaFactory factory){
        this.factory = new PizzaFactory();
    }

    public Pizza orderPizza(String pizzaType, double diameter) {
        Pizza pizza = factory.createPizza(pizzaType, diameter);
        pizza.prepare();
        pizza.bake();
        pizza.box();
        return pizza;
    }
}
