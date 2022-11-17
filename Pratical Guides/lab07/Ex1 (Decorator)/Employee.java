import java.util.Date;

public class Employee implements  EmpInterface {
    private String name;

    public Employee(String n) {
        name = n;
    }
    @Override
    public void start(Date sd) {
        System.out.println(this.name + "started working on " + sd.toString());
    }
    @Override
    public void terminate(Date td) {

        System.out.println(this.name + "stopped working on " + td.toString());
    }
    @Override
    public void work() {
        System.out.println("Employee " + this.name + " is working.");
    }

    @Override
    public String getName() {
        return name;
    }
}