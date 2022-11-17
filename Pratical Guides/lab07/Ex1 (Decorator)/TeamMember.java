import java.util.Date;

public class TeamMember extends EmpDecorator {
    public TeamMember(EmpInterface emp) { super(emp); }
    public void work() {
        emp.work();
        System.out.println(emp.getName() + " [TEAMMEMBER] is working!");
    }
    public void colaborate() {
        System.out.println(emp.getName() + " [TEAMMEMBER] is colaborating!");
    }
}
