public class Cake {
    private Shape shape;
    private String cakeLayer;
    private int numCakeLayers;
    private Cream midLayerCream;
    private Cream topLayerCream;
    private Topping topping;
    private String message;
//.. restantes métodos

    // constructor
    Cake() {
        this.shape = Shape.Circle;
        this.numCakeLayers = 1;
    }

    // shape methods
    public Shape getShape() {
        return this.shape;
    }
    public void setShape(Shape s) {
        this.shape = s;
    }

    // Layers and cream methods
    public String getCakeLayer() {
        return this.cakeLayer;
    }
    public void setCakeLayer(String cl) {
        this.cakeLayer = cl;
    }

    public int getNumCakeLayers() {
        return this.numCakeLayers;
    }
    public void setNumCakeLayers(int numCL) {
        this.numCakeLayers = numCL;
    }

    public Cream getMidLayerCream() {
        return this.midLayerCream;
    }
    public void setMidLayerCream(Cream midLC) {
        this.midLayerCream = midLC;
    }

    public Cream getTopLayerCream() {
        return this.topLayerCream;
    }
    public void setTopLayerCream(Cream topLC) {
        this.topLayerCream = topLC;
    }

    // Topping methods
    public Topping getTopping() {
        return this.topping;
    }
    public void setTopping(Topping t) {
        this.topping = t;
    }

    // Message methods
    public String getMessage() {
        return this.message;
    }
    public void setMessage(String m) {
        this.message = m;
    }

    @Override
    public String toString() {
        String cake = this.cakeLayer + " cake with " + this.numCakeLayers + " layers";

        if (this.numCakeLayers > 1) {
            cake += " and " + this.midLayerCream + " cream";
        }

        cake += ", topped with " + this.topLayerCream + " cream and " + this.topping + ".";

        if (this.message.isEmpty() != true) {
            cake += " Message says: \"" + this.message + "\".\n";
        }

        return cake;
    }
}