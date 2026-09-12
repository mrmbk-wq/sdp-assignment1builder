package com.astanait;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPizzaBuilder implements PizzaBuilder {

    protected Size size;
    protected String crustType;
    protected String sauceType;
    protected final List<String> cheeses = new ArrayList<>();
    protected final List<String> toppings = new ArrayList<>();

    @Override
    public PizzaBuilder setSize(Size size) {
        this.size = size;
        return this;
    }

    @Override
    public PizzaBuilder setCrust(String crustType) {
        this.crustType = crustType;
        return this;
    }

    @Override
    public PizzaBuilder setSauce(String sauceType) {
        this.sauceType = sauceType;
        return this;
    }

    @Override
    public PizzaBuilder addCheese(String cheeseType) {
        cheeses.add(cheeseType);
        return this;
    }

    @Override
    public PizzaBuilder addTopping(String topping) {
        toppings.add(topping);
        return this;
    }

    @Override
    public final Pizza build() {
        validateCommonState();
        validateStyleSpecificState();
        String bakingInstructions = describeAssembly();
        return new Pizza(size, crustType, sauceType, cheeses, toppings, bakingInstructions);
    }

    private void validateCommonState() {
        if (size == null) {
            throw new IllegalStateException("Pizza size must be set before building.");
        }
        if (crustType == null || crustType.isBlank()) {
            throw new IllegalStateException("Crust type must be set before building.");
        }
        if (sauceType == null || sauceType.isBlank()) {
            throw new IllegalStateException("Sauce type must be set before building.");
        }
        if (cheeses.isEmpty()) {
            throw new IllegalStateException("At least one cheese must be added before building.");
        }
    }

    protected abstract void validateStyleSpecificState();

    protected abstract String describeAssembly();
}

