package com.my.learnings.decorators.decorator.pizza.base;

public class BBQChicken implements Pizza {
    @Override
    public String getDescription() {
        return "BBQChicken";
    }

    @Override
    public int getCost() {
        return 200;
    }
}
