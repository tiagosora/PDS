import java.util.Date;

public class TeamLeader extends EmpDecorator {
    public TeamLeader(EmpInterface emp) { super(emp); }
    public void work() {
        emp.work();
        System.out.println(emp.getName() + " [TEAMLEADER] is working!");
    }
    public void plan() {
        System.out.println(emp.getName() + " [TEAMLEADER] is planning!");
    }
}