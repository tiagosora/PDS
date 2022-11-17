import java.util.Date;

public abstract class EmpDecorator implements EmpInterface {
    protected EmpInterface emp;

    public EmpDecorator(EmpInterface emp) { this.emp = emp; }
    public void start(Date sd) { emp.start(sd); }
    public void terminate(Date td) { emp.terminate(td); }
    public void work() { emp.work(); }
    public String getName() { return emp.getName(); }
}