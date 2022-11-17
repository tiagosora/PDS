package Ex3;
public class Bebida extends Produto{
    private String name;
    private Double weight;
    public Bebida(String name, int weight){
        this.name = name;
        this.weight = Double.valueOf(weight);
    }
    @Override
    public Double getWeight() {
        return weight;
    }
    @Override
    public void draw() {
        System.out.println((" ".repeat(Cabazes.avanço))+"Bebida '"+this.name+"' - Weight : "+getWeight());        
    }
}