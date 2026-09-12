package com.astanait;

import java.util.Collections;
import java.util.List;

public final class Pizza {

    private final Size size;
    private final String crustType;
    private final String sauceType;
    private final List<String> cheeses;
    private final List<String> toppings;
    private final String bakingInstructions;

    Pizza(Size size,
          String crustType,
          String sauceType,
          List<String> cheeses,
          List<String> toppings,
          String bakingInstructions) {
        this.size = size;
        this.crustType = crustType;
        this.sauceType = sauceType;
        this.cheeses = Collections.unmodifiableList(cheeses);
        this.toppings = Collections.unmodifiableList(toppings);
        this.bakingInstructions = bakingInstructions;
    }

    public Size getSize() { return size; }
    public String getCrustType() { return crustType; }
    public String getSauceType() { return sauceType; }
    public List<String> getCheeses() { return cheeses; }
    public List<String> getToppings() { return toppings; }
    public String getBakingInstructions() { return bakingInstructions; }

    @Override
    public String toString() {
        return String.format(
                "Pizza[%s inch, %s crust, %s sauce, cheeses=%s, toppings=%s] -> %s",
                size.getDiameterInches(), crustType, sauceType, cheeses, toppings, bakingInstructions
        );
    }
}