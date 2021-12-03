package StrategyDesignPattern.fly;

import StrategyDesignPattern.FlyStrategy;

public class FlyHigh implements FlyStrategy {

    @Override
    public void fly() {
        System.out.println("Fly high");
    }
}
