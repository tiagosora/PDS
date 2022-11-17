package Ex2;

public class PastaChef extends Chef {
    @Override
    public void chef(String menu) {
        if (canHandleMenu(menu, "pasta"))
            System.out.println("PastaChef: Starting to cook " + menu + ". Out in 14 minutes!\n");
        else {
            System.out.println("PastaChef: I can't cook that.");
            super.chef(menu);
        }
    }
}