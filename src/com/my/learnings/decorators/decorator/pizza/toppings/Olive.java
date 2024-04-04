package com.my.learnings.decorators.decorator.pizza.toppings;

import com.my.learnings.decorators.decorator.pizza.base.Pizza;

public class Olive implements Pizza {
    Pizza pizza;

    public Olive(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() +" + Olive";
    }

    @Override
    public int getCost() {
        return pizza.getCost() + 20;
    }
}
