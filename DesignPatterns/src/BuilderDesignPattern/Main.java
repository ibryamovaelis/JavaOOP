package BuilderDesignPattern;

public class Main {
    public static void main(String[] args) {
        Pizza pizza = new Pizza().withWeight(200).withName("Margherita").withTopping("A");
        Pizza pizza2 = new Pizza().withWeight(300).withName("Diavola").withTopping("B");
    }
}
