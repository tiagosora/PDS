public class CoconutCakeBuilder implements CakeBuilder {
    private Cake cake = new Cake();

    public void setCakeShape(Shape s) {
        this.cake.setShape(s);
    }

    public void createCake() {
        this.cake.setCakeLayer("Coconut");
    }

    public void addCakeLayer(int l) {
        this.cake.setNumCakeLayers(l);
    }

    public void addCreamLayer() {
        this.cake.setMidLayerCream(Cream.Chocolate);
    }

    public void addTopLayer() {
        this.cake.setTopLayerCream(Cream.Straw_Berries);
    }

    public void addTopping() {
        this.cake.setTopping(Topping.Coconut);
    }

    public void addMessage(String m) {
        this.cake.setMessage(m);
    }

    public Cake getCake() {
        return this.cake;
    }
}