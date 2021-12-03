package StrategyDesignPattern.fly;

import StrategyDesignPattern.FlyStrategy;

public class FlyNearBeach implements FlyStrategy {
    @Override
    public void fly() {
        System.out.println("Fly by the beach");
    }
}
