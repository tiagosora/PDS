package Ex1;

public class Ex1_main {
    public static void main(String args[]) {
        System.out.println("Teste para o código dos Resgistos.\n");
        Empregado e1 = new Empregado("Maria", "Antónia", 100, 1200.50);
        Empregado e2 = new Empregado("José", "Rodrigues", 101, 1000.0);
        Registos reg = new Registos();

        reg.insere(e1);
        reg.insere(e2);
        /*for (Empregado x : reg.listaDeEmpregados()) {
            System.out.println(x);
        }*/
        reg.listaDeEmpregados();

        System.out.println(reg.isEmpregado(101) ? "É empregado" : "Não é empregado");
        reg.remove(101);
        System.out.println(reg.isEmpregado(101) ? "É empregado" : "Não é empregado");
        System.out.println();

//------------------------------------------------------------------------------------\\

        System.out.println("Teste para o código da Database.\n");

        Employee emp1 = new Employee("Joana Pires", 100, 1200.50);
        Employee emp2 = new Employee("Manuel Gustavo", 101, 1000.0);
        Database db = new Database();

        db.addEmployee(emp1);
        db.addEmployee(emp2);
        for (Employee x : db.getAllEmployees()) {
            System.out.println(x);
        }
        db.deleteEmployee(101);
        for (Employee x : db.getAllEmployees()) {
            System.out.println(x);
        }
    }
}