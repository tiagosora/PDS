package Ex2;

public class PizzaChef extends Chef {
    @Override
    public void chef(String menu) {
        if (canHandleMenu(menu, "pizza")) {
            System.out.println("PizzaChef: Starting to cook " + menu + ". Out in 7 minutes!\n");
        }
        else {
            System.out.println("PizzaChef: I can't cook that.");
            super.chef(menu);
        }
    }
}