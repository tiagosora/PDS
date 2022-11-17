import java.util.Date;

public class Manager extends EmpDecorator {
    public Manager(EmpInterface emp) { super(emp); }
    public void work() {
        emp.work();
        System.out.println(emp.getName() + " [MANAGER] is working!");
    }
    public void manage() {
        System.out.println(emp.getName() + " [MANAGER] is managing!");
    }
}