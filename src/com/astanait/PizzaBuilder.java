package com.astanait;

public interface PizzaBuilder {

    PizzaBuilder setSize(Size size);

    PizzaBuilder setCrust(String crustType);

    PizzaBuilder setSauce(String sauceType);

    PizzaBuilder addCheese(String cheeseType);

    PizzaBuilder addTopping(String topping);

    Pizza build();
}
