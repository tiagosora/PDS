public enum Shape {
    Circle("Circle"),
    Square("Square"),
    Triangle("Triangle");

    private String shape;

    private Shape(String s) {
        this.shape = s;
    }

    @Override
    public String toString() {
        return this.shape;
    }
}