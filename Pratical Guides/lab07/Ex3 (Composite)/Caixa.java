package Ex3;
import java.util.ArrayList;
public class Caixa extends Produto{
    private String name;
    private Double weight;
    private ArrayList<Produto> produtos;
    public Caixa(String name, int weight){
        this.name = name;
        this.weight = Double.valueOf(weight);
        produtos = new ArrayList<>();
    }
    public void add(Produto produto){
        produtos.add(produto);
    }
    public String getName() {
        return name;
    }
    @Override
    public Double getWeight() {
        Double total = 0.0;
        for (Produto produto : produtos) {
            total += produto.getWeight();
        }
        return total;
    }
    @Override
    public void draw() {
        System.out.println((" ".repeat(Cabazes.avanço))+"* Caixa '"+this.name+"' [ Weight: "+Double.toString(this.weight)+" ; Total: "+Double.toString(getWeight())+" ]");
        Cabazes.avanço += 2;
        for (Produto produto : produtos) {
            produto.draw();
        }
        Cabazes.avanço -= 2;
    }
}