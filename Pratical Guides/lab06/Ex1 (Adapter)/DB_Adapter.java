package Ex1;
public class DB_Adapter extends Registos {
    private Database db;

    public DB_Adapter(Database db) {
        super();
        this.db = db;
    }

    public void insere(Employee emp) {
        // Code to insert employee
        db.addEmployee(emp);
    }
    public void remove(long codigo) {
        // Code to remove employee
        db.deleteEmployee(codigo);
    }
    public boolean isEmpregado(long codigo) {
        // Code to find employee
        for (Employee e : db.getAllEmployees()) {
            if (e.getEmpNum() == codigo)
                return true;
        }
        return false;
    }
    public void empregados() {
        // Code to retrieve collection
        for (Employee x : db.getAllEmployees()) {
            System.out.println(x);
        }
    }
}