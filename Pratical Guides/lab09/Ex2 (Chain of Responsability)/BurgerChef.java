package Ex2;

public class BurgerChef extends Chef {
    @Override
    public void chef(String menu) {
        if (canHandleMenu(menu, "burger")) {
            System.out.println("BurgerChef: Starting to cook " + menu + ". Out in 19 minutes!\n");
        }
        else {
            System.out.println("BurgerChef: I can't cook that.");
            super.chef(menu);
        }
    }
}