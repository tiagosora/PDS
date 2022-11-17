package Ex2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Company {
    public static User user; 
    private List<Employee> emps = new ArrayList<>(); 
    private SocialSecurity ss = new SocialSecurity();
    private Insurance insurance = new Insurance();
    private EmployeeCard cards = new EmployeeCard();
    private Parking park = new Parking(); 

    public void admitEmployee(Person person, int salary){ 
        Employee e = new Employee(person.getName(), Double.valueOf(salary)); 
        emps.add(e);
        ss.regist(person);
        insurance.regist(person);
        cards.CreateCard(person);
        if (e.getSalary() > averageSalary()) {
            park.allow(person);
        }
    } 

    public void paySalaries(int month){
        for(Employee e : emps ){ 
            BankAccount ba = e.getBankAccount(); 
            ba.deposit(e.getSalary());
        } 
    } 

    public List<Employee> employees(){ 
        return Collections.unmodifiableList(emps); 
    }

    public Double averageSalary() {
        double totalSalaries = 0; 
        for (Employee p : emps) 
            totalSalaries += p.getSalary();

        double average = totalSalaries / emps.size();
        return average;
    }
}