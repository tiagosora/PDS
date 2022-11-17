package Ex1;

import java.util.ArrayList;

public class Produto {
    public enum Estado {
        STOCK,
        LEILAO,
        VENDIDO;
    }
    private int codigo;
    private String descricao;
    private Double preco;
    private Estado estado;
    private Cliente comprador;
    private ArrayList<Observer> observers;
    
    public Produto(String descricao, Double preco){
        this.descricao = descricao;
        this.preco = preco;
        observers = new ArrayList<>();
    }
    public void notifyObservers(boolean novaLicitacao) throws InterruptedException {
        for (Observer observer : observers) {
            if (observer != this.comprador)
                observer.update(this,novaLicitacao);
        }
    }
    public void attach(Observer observer){
        this.observers.add(observer);
    }

    public int getCodigo() {
        return codigo;
    }
    public Cliente getComprador() {
        return comprador;
    }
    public String getDescricao() {
        return descricao;
    }
    public Estado getEstado() {
        return estado;
    }
    public ArrayList<Observer> getObservers() {
        return observers;
    }
    public Double getPreco() {
        return preco;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public void setComprador(Cliente comprador) {
        this.comprador = comprador;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public void setEstado(Estado estado) throws InterruptedException {
        this.estado = estado;
        this.notifyObservers(false);
    }
    public void setObservers(ArrayList<Observer> observers) {
        this.observers = observers;
    }
    public void setPreco(Double preco) throws InterruptedException {
        this.preco = preco;
        this.notifyObservers(true);
    }
    @Override
    public String toString() {
        return "[" + descricao + "]";
    }
}