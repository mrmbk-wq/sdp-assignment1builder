# Pizza Builder — Assignment #1 (Builder Pattern)

**Course:** ShP-2216 — Software Design Patterns, Astana IT University

## What this is

A Java 17 implementation of the **Builder** creational design pattern, using pizza
construction as the domain. Two concrete builders produce genuinely different
representations of the `Pizza` product:

| Builder | Style | Notable difference |
|---|---|---|
| `NeapolitanPizzaBuilder` | Thin-crust, wood-fired | Small/medium only, max 3 toppings, sauce goes under the cheese, ~90s high-heat bake |
| `ChicagoDeepDishPizzaBuilder` | Deep dish, pan-baked | Medium+ only, requires a "Deep Dish" crust, chunky sauce goes **on top** of the toppings, ~35 min bake |

## Structure

```
src/main/java/com/astanait/pizzabuilder/
 ├─ Pizza.java                      # Product — immutable, package-private constructor
 ├─ Size.java                       # Enum — removes magic numbers/strings for sizing
 ├─ PizzaBuilder.java                # Builder interface — fluent construction steps
 ├─ AbstractPizzaBuilder.java        # Shared setters + validation template method
 ├─ NeapolitanPizzaBuilder.java      # ConcreteBuilder #1
 ├─ ChicagoDeepDishPizzaBuilder.java # ConcreteBuilder #2
 ├─ PizzaDirector.java               # Director — reusable "house recipes"
 └─ Main.java                        # Client — demo / test class
uml-class-diagram.puml               # PlantUML source for the report's UML diagram
uml-class-diagram.png                # Rendered diagram
```

## How to build each representation

Directly with a builder (fluent chaining):

```java
Pizza custom = new NeapolitanPizzaBuilder()
        .setSize(Size.SMALL)
        .setCrust("Thin")
        .setSauce("Tomato")
        .addCheese("Mozzarella")
        .addTopping("Mushroom")
        .build();
```

Or via the Director, for a known recipe:

```java
PizzaDirector director = new PizzaDirector();
Pizza margherita = director.buildMargherita(new NeapolitanPizzaBuilder(), Size.MEDIUM);
Pizza deepDish   = director.buildMeatLoversDeepDish(new ChicagoDeepDishPizzaBuilder(), Size.LARGE);
```

Invalid combinations (e.g. a `SMALL` deep dish) throw a clear
`IllegalStateException` from `build()` instead of producing a broken `Pizza`.

## How to run

Requires JDK 17+.

```bash
javac -d out $(find src -name "*.java")
java -cp out com.astanait.pizzabuilder.Main
```

Expected output:

```
Margherita:   Pizza[12 inch, Thin crust, Tomato sauce, cheeses=[Mozzarella], toppings=[Fresh Basil]] -> ...
Meat Lovers:  Pizza[16 inch, Deep Dish crust, Chunky Tomato sauce, cheeses=[Mozzarella, Cheddar], toppings=[Italian Sausage, Pepperoni, Bacon]] -> ...
Custom Veggie:Pizza[10 inch, Thin crust, Tomato sauce, cheeses=[Mozzarella], toppings=[Mushroom, Bell Pepper]] -> ...
Validation caught an invalid pizza: Chicago deep dish needs at least a MEDIUM pan, not SMALL
```

## Regenerating the UML diagram

```bash
plantuml uml-class-diagram.puml
```
(or paste `uml-class-diagram.puml` into any PlantUML renderer / UMLet.)
