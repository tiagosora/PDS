public enum Topping {
    Fruit("Fruit"),
    Chocolate("Chocolate"),
    Coconut("Coconut");

    private String topping;

    private Topping(String t) {
        this.topping = t;
    }

    @Override
    public String toString() {
        return this.topping;
    }
}