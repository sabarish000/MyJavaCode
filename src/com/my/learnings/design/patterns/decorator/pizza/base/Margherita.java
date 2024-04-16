package com.my.learnings.design.patterns.decorator.pizza.base;

public class Margherita implements Pizza {
    @Override
    public String getDescription() {
        return "Margherita";
    }

    @Override
    public int getCost() {
        return 200;
    }
}
