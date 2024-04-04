package com.my.learnings.decorators.decorator.pizza;

import com.my.learnings.decorators.decorator.pizza.base.BBQChicken;
import com.my.learnings.decorators.decorator.pizza.base.Margherita;
import com.my.learnings.decorators.decorator.pizza.base.Pizza;
import com.my.learnings.decorators.decorator.pizza.toppings.Cheese;
import com.my.learnings.decorators.decorator.pizza.toppings.Olive;
import com.my.learnings.decorators.decorator.pizza.toppings.Paneer;
import com.my.learnings.decorators.decorator.pizza.toppings.Tomato;

/*
*
Please create a class diagram and code to represent a Pizza with the following set of requirements.
Every pizza has a name and a description.
We need to get the cost and description of constituents of the pizza.
There are 4 base pizzas on which toppings can be added later, if needed by the customer. These pizzas, along with their costs, are:
Farmhouse - Rs. 150
Margherita - Rs. 200
Pepperoni - Rs. 180
BBQChicken - Rs. 200
There are 4 types of toppings that are supported. A customer may want to add any quantity of them (Eg: They may want to add Olives twice). The toppings, along with their costs, are:
Olive - Rs. 20
Tomato - Rs. 30
Cheese - Rs. 80
Paneer - Rs. 60

* */
public class Client {
    public static void main(String[] args) {
        Pizza p = new Paneer(new Cheese(new Tomato(new BBQChicken())));
        System.out.println(p.getCost()); // should output 370
        System.out.println(p.getDescription());
        // should output BBChicken + Tomato + Cheese + Paneer

        Pizza p2 = new Paneer(new Olive(new Cheese(new Margherita())));
        System.out.println(p2.getCost()); // should output 360
        System.out.println(p2.getDescription());
        // should output Margherita + Cheese + Olive + Paneer
    }
}
