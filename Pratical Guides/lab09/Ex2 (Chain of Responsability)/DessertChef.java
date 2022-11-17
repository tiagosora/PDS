package Ex2;

public class DessertChef extends Chef {
    @Override
    public void chef(String menu) {
        if (canHandleMenu(menu, "dessert"))
            System.out.println("DessertChef: Starting to cook " + menu + ". Out in 17 minutes!\n");
        else{
            System.out.println("DessertChef: I can't cook that.");
            super.chef(menu);
        }
    }
}