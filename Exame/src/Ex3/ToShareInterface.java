package Ex3;
public interface ToShareInterface {
    public boolean add(Product p);
    public boolean share(Product p, Observer user);
    public boolean giveBack(Product p);
}