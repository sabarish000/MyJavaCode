package com.my.learnings.design.patterns.decorator.pizza.base;

public class Farmhouse implements Pizza {
    @Override
    public String getDescription() {
        return "Farmhouse";
    }

    @Override
    public int getCost() {
        return 150;
    }
}
