package Ex3;

public abstract class Observer {
    private String digitos;
    private String nome;
    public abstract void update(Product produto, int pos);

    public Observer(String digitos, String nome) {
        this.digitos = digitos;
        this.nome = nome;
    }
    public void getNotified(Product p) {
        p.attach(this);
    }

    public String getDigitos() {
        return digitos;
    }
    public void setDigitos(String digitos) {
        this.digitos = digitos;
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
