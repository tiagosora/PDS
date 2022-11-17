package Ex2;

public abstract class Chef { // abstract
    private Chef successor = null;

    public void chef(String menu) {
        if (successor != null) 
            successor.chef(menu);
        else
            System.out.println("We're sorry but that request can't be satisfied by our service!\n");
    }

    protected boolean canHandleMenu(String menu, String type) {
        return (menu == null) || (menu.toLowerCase().contains(type.toLowerCase()));
    } 
    
    public Chef next(Chef next){
        this.successor = next;
        return this;
    }
}
