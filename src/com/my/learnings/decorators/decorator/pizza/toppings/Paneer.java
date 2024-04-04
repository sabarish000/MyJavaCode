package com.my.learnings.decorators.decorator.pizza.toppings;

import com.my.learnings.decorators.decorator.pizza.base.Pizza;

public class Paneer implements Pizza {
    Pizza pizza;

    public Paneer(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " + Paneer";
    }

    @Override
    public int getCost() {
        return pizza.getCost() + 60;
    }
}
