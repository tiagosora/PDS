import java.util.*;

public class ToShare implements ToShareInterface{

    ArrayList<Product> allProdutos;
    ArrayList<Product> availableProdutos;
    HashMap<Product, Client> sharedProdutos;

    public ToShare() {
        allProdutos = new ArrayList<>();
        availableProdutos = new ArrayList<>();
        sharedProdutos = new HashMap<>();
    }

    @Override
    public boolean add(Product p) {
        availableProdutos.add(p);
        allProdutos.add(p);
        return true;
    }

    @Override
    public Product remove(String code) {
        for (Product p : availableProdutos){
            if (p.code().equals(code)){
                allProdutos.remove(p);
                availableProdutos.remove(p);
                return p;
            }
        }
        return null;
    }

    @Override
    public Product remove(Product p) {
        allProdutos.remove(p);
        availableProdutos.remove(p);
        return p;
    }

    @Override
    public boolean share(String code, Client user) {
        for (Product p : availableProdutos){
            if (p.code().equals(code)){
                sharedProdutos.put(p, user);
                availableProdutos.remove(p);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean share(Product p, Client user) {
        if (availableProdutos.contains(p)){
            sharedProdutos.put(p, user);
            availableProdutos.remove(p);
            return true;
        }
        return false;
    }

    @Override
    public boolean giveBack(String code) {
        for (Product p : sharedProdutos.keySet()){
            if (p.code().equals(code)){
                sharedProdutos.remove(p);
            availableProdutos.add(p);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean giveBack(Product p) {
        if (sharedProdutos.containsKey(p)){
            sharedProdutos.remove(p);
            availableProdutos.add(p);
            return true;
        }
        return false;
    }

    public String totalProducts() {
        return Integer.toString(allProdutos.size());
    }

    public ArrayList<Product> getProducts() {
        return allProdutos;
    }

    public String sharedProducts() {
        String returString = "Total: "+Integer.toString(sharedProdutos.size())+"\n";
        for (Product product : sharedProdutos.keySet()) {
            returString += "\t"+product.toString()+"\n";
        }
        return returString;
    }

}
