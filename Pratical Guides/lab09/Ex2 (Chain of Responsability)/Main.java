package Ex2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> plates = new ArrayList<>();

        plates.add("veggie burger");
        plates.add("Pasta Carbonara");
        plates.add("PLAIN pizza");
        plates.add("sushi nigiri and sashimi");
        plates.add("salad with tuna");
        plates.add("strawberry ice cream and waffles dessert");
        plates.add("bacalhau à gomes de sá");

        Chef chefinho = new SushiChef().next (
                new PastaChef().next (
                    new BurgerChef().next (
                        new PizzaChef().next (
                            new DessertChef()
                        )
                    )
                )
            );

        for (String plate : plates) {
            System.out.println("Can I get a " + plate + "?");
            chefinho.chef(plate);
        }
    }
}