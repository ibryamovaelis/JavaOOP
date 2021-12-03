package FactoryDesignPattern;

public class BulgarianPizza extends Pizza{
    public BulgarianPizza(double diameter) {
        super(diameter);
    }

    @Override
    public void prepare() {
        System.out.println("Preparing Bulgarian Pizza.");
    }

    @Override
    public void bake() {
        System.out.println("Baking Bulgarian Pizza.");
    }

    @Override
    public void box() {
        System.out.println("Boxing Bulgarian Pizza.");
    }
}
