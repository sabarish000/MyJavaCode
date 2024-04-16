package com.my.learnings.design.patterns.decorator.pizza.toppings;

import com.my.learnings.design.patterns.decorator.pizza.base.Pizza;

public class Cheese implements Pizza {
    Pizza pizza;

    public Cheese(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " + Cheese";
    }

    @Override
    public int getCost() {
        return pizza.getCost() + 80;
    }
}
