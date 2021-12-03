package StrategyDesignPattern;

import StrategyDesignPattern.fly.FlyHigh;
import StrategyDesignPattern.fly.FlyNearBeach;

public class Main {
    public static void main(String[] args) {
        Bird seagull = new Bird(new FlyNearBeach());
        seagull.fly();
        seagull.setStrategy(new FlyHigh());
        seagull.fly();
    }
}
