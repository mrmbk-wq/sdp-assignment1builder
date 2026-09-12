package com.astanait;

public class Main {

    public static void main(String[] args) {
        PizzaDirector director = new PizzaDirector();

        Pizza margherita = director.buildMargherita(new NeapolitanPizzaBuilder(), Size.MEDIUM);
        System.out.println("Margherita:   " + margherita);

        Pizza meatLovers = director.buildMeatLoversDeepDish(new ChicagoDeepDishPizzaBuilder(), Size.LARGE);
        System.out.println("Meat Lovers:  " + meatLovers);

        Pizza customVeggie = new NeapolitanPizzaBuilder()
                .setSize(Size.SMALL)
                .setCrust("Thin")
                .setSauce("Tomato")
                .addCheese("Mozzarella")
                .addTopping("Mushroom")
                .addTopping("Bell Pepper")
                .build();
        System.out.println("Custom Veggie:" + customVeggie);

        try {
            new ChicagoDeepDishPizzaBuilder()
                    .setSize(Size.SMALL)
                    .setCrust("Deep Dish")
                    .setSauce("Chunky Tomato")
                    .addCheese("Mozzarella")
                    .build();
        } catch (IllegalStateException e) {
            System.out.println("Validation caught an invalid pizza: " + e.getMessage());
        }
    }
}
