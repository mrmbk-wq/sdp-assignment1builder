package com.astanait;

public class NeapolitanPizzaBuilder extends AbstractPizzaBuilder {

    private static final int MAX_NEAPOLITAN_TOPPINGS = 3;

    @Override
    protected void validateStyleSpecificState() {
        if (size == Size.LARGE || size == Size.EXTRA_LARGE) {
            throw new IllegalStateException(
                    "Neapolitan pizza is traditionally SMALL or MEDIUM (12in max), not " + size);
        }
        if (toppings.size() > MAX_NEAPOLITAN_TOPPINGS) {
            throw new IllegalStateException(
                    "Neapolitan pizza keeps toppings minimal (max " + MAX_NEAPOLITAN_TOPPINGS + ").");
        }
    }

    @Override
    protected String describeAssembly() {
        return "Hand-stretched thin crust, layered crust -> sauce -> cheese -> toppings, "
                + "baked ~90 seconds at 480C in a wood-fired oven.";
    }
}
