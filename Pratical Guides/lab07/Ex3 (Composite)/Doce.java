package Ex3;
public class Doce extends Produto{
    private String name;
    private Double weight;
    public Doce(String name, int weight){
        this.name = name;
        this.weight = Double.valueOf(weight);
    }
    @Override
    public Double getWeight() {
        return weight;
    }
    @Override
    public void draw() {
        System.out.println((" ".repeat(Cabazes.avanço))+"Doce '"+this.name+"' - Weight : "+getWeight());        
    }
}