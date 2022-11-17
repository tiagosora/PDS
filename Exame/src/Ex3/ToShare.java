package Ex3;
import java.util.*;

public class ToShare implements ToShareInterface{

    ArrayList<Product> allProdutos;
    ArrayList<Product> availableProdutos;
    HashMap<Product, Observer> sharedProdutos;

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
    public boolean share(Product p, Observer user) {
        if (availableProdutos.contains(p)){
            if (p.getObservers().contains(user)) {
                p.removeObserver(user);
            }
            for (Observer u : p.getObservers()) {
                u.update(p, p.getObservers().indexOf(u));
            }
            sharedProdutos.put(p, user);
            availableProdutos.remove(p);
            System.out.println("Produto : "+p+" emprestado a "+user);
            return true;
        }
        System.out.println("PRODUTO : "+p+" NAO PODE SER EMPRESTADO A "+user);
        return false;
    }

    @Override
    public boolean giveBack(Product p) {
        if (sharedProdutos.containsKey(p)){
            sharedProdutos.remove(p);
            availableProdutos.add(p);
            System.out.println("Produto : "+p+" devolvido");
            if (p.getObservers().size() > 0){
                share(p, p.getObservers().get(0));
            }
            return true;
        }
        System.out.println("PRODUTO : "+p+" NAO PODE SER DEVOLVIDO");
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
