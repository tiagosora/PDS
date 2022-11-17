package Ex1;
import java.util.ArrayList;
public abstract class Observer {
    protected ArrayList<Produto> leilao; 
    protected String nome;
    public abstract void update(Produto produto, boolean onSale) throws InterruptedException;

    public Observer(String nome) {
        this.nome = nome;
        this.leilao = new ArrayList<Produto>();
    }
    public void getNotified(Produto p) {
        p.attach(this);
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    @Override
    public String toString(){
        return this.nome;
    }
}