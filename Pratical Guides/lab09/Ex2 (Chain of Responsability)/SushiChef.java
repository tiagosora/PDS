package Ex2;

public class SushiChef extends Chef {
    @Override
    public void chef(String menu) {
        if (canHandleMenu(menu, "sushi")) {
            System.out.println("SushiChef: Starting to cook " + menu + ". Out in 14 minutes!\n");
        }
        else {
            System.out.println("SushiChef: I can't cook that.");
            super.chef(menu);
        }
    }
}