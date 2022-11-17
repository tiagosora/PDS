public class CakeMaster {
    private CakeBuilder builder;
    public void setCakeBuilder(CakeBuilder b) {
        this.builder = b;
    }

    // Only with cake message
    public void createCake(String m) {
        this.builder.createCake();
        this.builder.addCreamLayer();
        this.builder.addTopLayer();
        this.builder.addTopping();
        this.builder.addMessage(m);
    }

    // With shape, layers and message
    public void createCake(Shape s, int l, String m) {
        this.builder.createCake();
        this.builder.addCakeLayer(l);
        this.builder.setCakeShape(s);
        this.builder.addCreamLayer();
        this.builder.addTopLayer();
        this.builder.addTopping();
        this.builder.addMessage(m);
    }

    // With layers and message
    public void createCake(int l, String m) {
        this.builder.createCake();
        this.builder.addCakeLayer(l);
        this.builder.addCreamLayer();
        this.builder.addTopLayer();
        this.builder.addTopping();
        this.builder.addMessage(m);
    }

    // return cake
    public Cake getCake() {
        return this.builder.getCake();
    }
}