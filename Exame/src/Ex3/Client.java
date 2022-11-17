package Ex3;

public class Client extends Observer{
    

    public Client(String digitos, String nome) {
        super(digitos, nome);
    }

    public void getNotified(Product produto) {
        produto.attach(this);
        System.out.println("O observer " + this.getNome() + " mostrou-se interessado no produto " + produto.code());
    }

    @Override
    public void update(Product produto, int pos){
        System.out.println("O observer " + this.getNome() + " soube que está na posição " + (pos+1) + " de ter o produto " + produto.code());        
    }

}
