package com.my.learnings.decorators.decorator.pizza.base;

public class Pepperoni implements Pizza {
    @Override
    public String getDescription() {
        return "Pepperoni";
    }

    @Override
    public int getCost() {
        return 180;
    }
}
