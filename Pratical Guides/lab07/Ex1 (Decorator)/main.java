import java.util.Date;

public class main {
    public static void main(String[] args) {
        EmpInterface e = new Employee("José");
        TeamLeader tl = new TeamLeader(new Employee("Maria"));
        TeamMember tm = new TeamMember(new Employee("João"));
        Manager m1 = new Manager(new TeamMember(new Employee("Pedro")));
        Manager m2 = new Manager(new TeamLeader(new TeamMember(new Employee("Ana"))));

        EmpInterface [] emps = {e, tl, tm, m1, m2};

        for (EmpInterface i: emps) {
            i.work();
            if (i instanceof TeamLeader){
                ((TeamLeader) i).plan();
            }
            if (i instanceof TeamMember){
                ((TeamMember) i).colaborate();
            }
            if (i instanceof Manager){
                ((Manager) i).manage();
            }
        }
    }
}