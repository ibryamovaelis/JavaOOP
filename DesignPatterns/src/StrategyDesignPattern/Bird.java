package StrategyDesignPattern;

public class Bird {
    FlyStrategy strategy;

    public Bird(FlyStrategy strategy) {
        this.strategy = strategy;
    }

    public void fly() {
        this.strategy.fly();
    }

    public FlyStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(FlyStrategy strategy) {
        this.strategy = strategy;
    }
}
