package com.my.learnings.decorators.decorator.pizza.toppings;

import com.my.learnings.decorators.decorator.pizza.base.Pizza;

public class Tomato implements Pizza {
    Pizza pizza;
    public Tomato(Pizza pizza) {
        this.pizza =pizza;
    }
    @Override
    public String getDescription() {
        return pizza.getDescription() + " + Tomato";
    }

    @Override
    public int getCost() {
        return pizza.getCost() + 30;
    }
}
