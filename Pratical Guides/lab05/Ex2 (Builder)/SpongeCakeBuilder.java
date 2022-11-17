public class SpongeCakeBuilder implements CakeBuilder {
    private Cake cake = new Cake();

    public void setCakeShape(Shape s) {
        this.cake.setShape(s);
    }

    public void createCake() {
        this.cake.setCakeLayer("Sponge");
    }

    public void addCakeLayer(int l) {
        this.cake.setNumCakeLayers(l);
    }

    public void addCreamLayer() {
        this.cake.setMidLayerCream(Cream.Red_Berries);
    }

    public void addTopLayer() {
        this.cake.setTopLayerCream(Cream.Whipped_Cream);
    }

    public void addTopping() {
        this.cake.setTopping(Topping.Fruit);
    }

    public void addMessage(String m) {
        this.cake.setMessage(m);
    }

    public Cake getCake() {
        return this.cake;
    }
}