package Ex1;
import Ex1.Produto.Estado;
public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Definir os produtos
        Produto produto_0 = new Produto("Agua Caramulo", 12.0);
        Produto produto_1 = new Produto("Agua Caramulo da Paradinha", 12.1);
        Produto produto_2 = new Produto("Agua Ports Discover Rena", 15.0);
        Produto produto_3 = new Produto("Agua Serra da Estrela", 10.0);
        Produto produto_4 = new Produto("Agua Tupperware", 20.0);

        // Definir o gestor e os produtos que ele gere
        Gestor gestor = new Gestor("Kelinhas Nokitas");

        gestor.getNotified(produto_0);
        gestor.getNotified(produto_1);
        gestor.getNotified(produto_2);
        gestor.getNotified(produto_3);
        gestor.getNotified(produto_4);

        // Definir os produtos em que os clientes estão interessados
        Cliente cliente_0 = new Cliente("Tatarinha PS");
        Cliente cliente_1 = new Cliente("Bea Gótica");
        Cliente cliente_2 = new Cliente("Paulo Segundo");
        
        cliente_0.getNotified(produto_0);
        cliente_0.getNotified(produto_2);
        cliente_0.getNotified(produto_4);
        
        cliente_1.getNotified(produto_0);
        cliente_1.getNotified(produto_1);
        cliente_1.getNotified(produto_3);

        cliente_2.getNotified(produto_0);
        cliente_2.getNotified(produto_1);
        cliente_2.getNotified(produto_2);
        cliente_2.getNotified(produto_3);
        cliente_2.getNotified(produto_4);

        System.out.println("--------------------------------------------------------------------");
        System.out.println("TENTATIVAS FALHADAS DE LICITAR");
        System.out.println("--------------------------------------------------------------------\n"); Thread.sleep(3000);
        cliente_0.licitar(produto_1, 0.0); Thread.sleep(2000);
        cliente_1.licitar(produto_4, 0.0); Thread.sleep(2000);

        System.out.println("--------------------------------------------------------------------");
        System.out.println("GESTOR: VAMOS COMEÇAR POR LEILOAR O PRODUTO 0"); 
        System.out.println("--------------------------------------------------------------------\n"); Thread.sleep(3000);
        gestor.atualizarEstado(produto_0, Estado.LEILAO); Thread.sleep(2000);
        cliente_0.licitar(produto_0, 12.2); Thread.sleep(2000);
        cliente_1.licitar(produto_0, 12.0); Thread.sleep(2000);
        cliente_2.licitar(produto_0, 13.0); Thread.sleep(2000);
        cliente_1.licitar(produto_0, 14.0); Thread.sleep(4000);
        gestor.atualizarEstado(produto_0, Estado.VENDIDO); Thread.sleep(2000);

        System.out.println("--------------------------------------------------------------------");
        System.out.println("GESTOR: AGORA IREMOS LEILOAR O PRODUTO 2");
        System.out.println("--------------------------------------------------------------------\n"); Thread.sleep(3000);
        gestor.atualizarEstado(produto_2, Estado.LEILAO); Thread.sleep(2000);
        cliente_0.licitar(produto_2, 17.5); Thread.sleep(2000);
        cliente_1.licitar(produto_2, 19.0); Thread.sleep(4000);
        gestor.atualizarEstado(produto_2, Estado.VENDIDO); Thread.sleep(2000);

        System.out.println("--------------------------------------------------------------------");
        System.out.println("GESTOR: AGORA VAMOS LEILOAR O PRODUTO 3");
        System.out.println("--------------------------------------------------------------------\n"); Thread.sleep(3000);
        gestor.atualizarEstado(produto_3, Estado.LEILAO); Thread.sleep(2000);
        gestor.atualizarEstado(produto_3, Estado.STOCK); Thread.sleep(2000);

        System.out.println("--------------------------------------------------------------------");
        System.out.println("GESTOR: PARA ACABAR VAMOS LEILOAR O PRODUTO 4");
        System.out.println("--------------------------------------------------------------------\n"); Thread.sleep(3000);
        gestor.atualizarEstado(produto_4, Estado.LEILAO); Thread.sleep(2000);
        cliente_2.licitar(produto_4, 12.5); Thread.sleep(4000);
        gestor.atualizarEstado(produto_4, Estado.VENDIDO); Thread.sleep(2000);
    }
}