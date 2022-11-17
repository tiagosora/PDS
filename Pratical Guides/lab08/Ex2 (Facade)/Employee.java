package Ex2;
public class Employee{
    private String name;
    private double salary;
    private BankAccount bankAccount; 
    public Employee(String n, double s){ 
        name = n;
        salary = s;
        bankAccount = new BankAccountImpl("PeDeMeia", 0);
    } 
    public double getSalary(){ 
        return salary; 
    }
    public BankAccount getBankAccount() {
        return bankAccount;
    }
    public String getName() {
        return name;
    }
}