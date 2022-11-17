package Ex3;
public class Conserva extends Produto{
    private String name;
    private Double weight;
    public Conserva(String name, int weight){
        this.name = name;
        this.weight = Double.valueOf(weight);
    }
    @Override
    public Double getWeight() {
        return weight;
    }
    @Override
    public void draw() {
        System.out.println((" ".repeat(Cabazes.avanço))+"Conserva '"+this.name+"' - Weight : "+getWeight());        
    }
}