package Ex1;
public class Cliente extends Observer{
    public Cliente(String nome){
        super(nome);
    }
    public void update(Produto produto, boolean onSale) {
        if (onSale) {
            System.out.println("\t[" + this + "] soube que " + produto.getComprador() + " licitou " + String.valueOf(produto.getPreco()));
        } else {
            switch (produto.getEstado()) {
                case STOCK:
                    this.leilao.remove(produto);
                    System.out.println("[" + this + "] soube que '" + produto + 
                    "' não recebeu nenhuma licitação e deixou de ser leiloado.");
                    break;
                case LEILAO:
                    this.leilao.add(produto);
                    break;
                case VENDIDO:
                    this.leilao.remove(produto);
                    System.out.println("[" + this + "] O produto '" + produto + 
                    "' foi vendido ao cliente " + produto.getComprador() + " por " + produto.getPreco() + "€.");
                    break;
            }
        }
    }
    @Override
    public String getNome() {
        return super.getNome();
    }
    @Override
    public void setNome(String nome) {
        super.setNome(nome);
    }
    public void getNotified(Produto produto) {
        produto.attach(this);
    }
    public void licitar(Produto produto, double preco) throws InterruptedException {
        if (leilao.contains(produto)) {
            if (preco > produto.getPreco()) {
                System.out.println("Nova licitação:");
                produto.setComprador(this);
                produto.setPreco(preco);
            } else {
                System.out.println("[" + this + "] Fez uma licitação de " + Double.toString(preco) + ", mas o valor atual do produto é " + produto.getPreco() + "€.");
            }
        } else {
            System.out.println("[" + this + "] Fez uma licitação, mas produto " + produto + " não está a ser leiloado.");
        }
        System.out.println();
    }
}