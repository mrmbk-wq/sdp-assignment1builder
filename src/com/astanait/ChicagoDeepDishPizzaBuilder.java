package com.astanait;

public class ChicagoDeepDishPizzaBuilder extends AbstractPizzaBuilder {

    @Override
    protected void validateStyleSpecificState() {
        if (size == Size.SMALL) {
            throw new IllegalStateException(
                    "Chicago deep dish needs at least a MEDIUM pan, not " + size);
        }
        if (!"Deep Dish".equalsIgnoreCase(crustType)) {
            throw new IllegalStateException(
                    "Chicago deep dish requires crustType \"Deep Dish\", got \"" + crustType + "\".");
        }
    }

    @Override
    protected String describeAssembly() {
        return "Buttery deep-dish crust pressed into a steel pan, layered crust -> cheese -> "
                + "toppings -> chunky sauce on top, baked ~35 minutes at 230C.";
    }
}

