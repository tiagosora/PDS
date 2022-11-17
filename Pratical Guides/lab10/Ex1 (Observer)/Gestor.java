package Ex1;
import java.util.ArrayList;
import Ex1.Produto.Estado;
public class Gestor extends Observer {
    private ArrayList<Produto> produtosStock;
    private ArrayList<Produto> produtosVendidos; 
    public Gestor(String nome) {
        super(nome);
        this.produtosStock = new ArrayList<Produto>();
        this.produtosVendidos = new ArrayList<Produto>();
    }
    public void atualizarEstado(Produto produto, Estado estado) throws InterruptedException {
        produto.setEstado(estado);
        System.out.println();
    }
    @Override
    public void update(Produto produto, boolean onSale) throws InterruptedException {
        if (onSale) {
            System.out.println("\t[GESTOR: " + this + "] | " + produto + " | " + produto.getComprador() + " licitou " + String.valueOf(produto.getPreco()) + "€.");
        } else {
            switch (produto.getEstado()) {
                case STOCK:
                    this.leilao.remove(produto);
                    this.produtosStock.add(produto);
                    System.out.println("[GESTOR " + this + "] O produto '" + produto + " não recebeu nenhuma licitação e vai para o stock.");
                    System.out.println();
                    break;
                case LEILAO:
                    this.leilao.add(produto);
                    this.produtosStock.remove(produto);
                    System.out.println("[GESTOR " + this + "] O produto '" + produto + " vai ser leiloado. Preço base: " + 
                    produto.getPreco() + "€.");
                    break;
                case VENDIDO:
                    this.leilao.remove(produto);
                    this.produtosVendidos.add(produto);
                    System.out.println("[GESTOR: " + this + "] Ninguem vai licitar?"); Thread.sleep(3000);
                    System.out.println("\t... Vai 2..."); Thread.sleep(1000);
                    System.out.println("\t... VAI 3..."); Thread.sleep(1000);
                    System.out.println("\t....Vai 1..."); Thread.sleep(1000);
                    System.out.println("[GESTOR: " + this + "] Vendido ao " + produto.getComprador() + 
                    " por " + String.valueOf(produto.getPreco()) + "€.");
                    System.out.println();
                    break;
            }
        }
    }
}