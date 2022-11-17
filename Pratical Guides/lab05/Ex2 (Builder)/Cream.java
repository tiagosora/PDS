public enum Cream {
    Whipped_Cream("Whipped_Cream"),
    Red_Berries("Red_Berries"),
    Vanilla("Vanilla"),
    Chocolate("Chocolate"),
    Straw_Berries("Straw_Berries");

    private String cream;

    private Cream(String c) {
        this.cream = c;
    }

    @Override
    public String toString() {
        return this.cream;
    }
}