package Ex1;

public class Ex2_main {
    public static void main(String args[]) {
        Database db = new Database();
        DB_Adapter adapter = new DB_Adapter(db);

        Employee e1 = new Employee("Joana Pires", 100, 1200.50);
        Employee e2 = new Employee("Manuel Gustavo", 101, 1000.0);

        adapter.insere(e1);
        adapter.insere(e2);

        adapter.empregados();

        if (adapter.isEmpregado(e1.getEmpNum())){
            adapter.remove(e1.getEmpNum());
        }
        adapter.empregados();
    }
}