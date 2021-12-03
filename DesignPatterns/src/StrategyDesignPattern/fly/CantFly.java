package StrategyDesignPattern.fly;

import StrategyDesignPattern.FlyStrategy;

public class CantFly implements FlyStrategy {
    @Override
    public void fly() {
        System.out.println("I can't fly.");
    }
}
