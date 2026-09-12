package com.astanait;

public class PizzaDirector {

    private static final String MOZZARELLA = "Mozzarella";
    private static final String TOMATO_SAUCE = "Tomato";

    public Pizza buildMargherita(PizzaBuilder builder, Size size) {
        return builder
                .setSize(size)
                .setCrust("Thin")
                .setSauce(TOMATO_SAUCE)
                .addCheese(MOZZARELLA)
                .addTopping("Fresh Basil")
                .build();
    }

    public Pizza buildMeatLoversDeepDish(PizzaBuilder builder, Size size) {
        return builder
                .setSize(size)
                .setCrust("Deep Dish")
                .setSauce("Chunky Tomato")
                .addCheese(MOZZARELLA)
                .addCheese("Cheddar")
                .addTopping("Italian Sausage")
                .addTopping("Pepperoni")
                .addTopping("Bacon")
                .build();
    }
}