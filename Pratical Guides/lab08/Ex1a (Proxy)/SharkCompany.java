package Ex1a;
import java.util.List;
public class SharkCompany {
    public static void main(String[] args) {
        Company shark = new Company(); 
        Company.user = User.COMPANY; 
        
        shark.admitPerson("Maria Silva", 1000); 
        shark.admitPerson("Manuel Pereira", 900); 
        shark.admitPerson("Aurora Machado", 1200); 
        shark.admitPerson("Augusto Lima", 1100);

        List<Employee> sharkEmps = shark.employees(); 
        
        System.out.println("Current user = Company ->");
        System.out.println("Before payment:");
        
        for(Employee e : sharkEmps){
            // "talking to strangers", but this is not a normal case
            if (e.getBankAccount().balance()!=-1){
                System.out.println("Current salary: " + Double.toString(e.getBankAccount().balance()));
            } else {
                System.out.println("Balance Operation was denied");
                break;
            }
                
        }
        
        System.out.println("\nAfter payment:");
        shark.paySalaries(1); 
        
        for(Employee e : sharkEmps){ 
            e.getBankAccount().withdraw(500);
            if (e.getBankAccount().balance()!=-1){
                System.out.println("Current salary: " + Double.toString(e.getBankAccount().balance()));
            } else {
                System.out.println("Balance Operation was denied");
                break;
            }
        }

        Company.user = User.OWNER;
        System.out.println("\nCurrent user = OWNER ->");
        System.out.println("Before payment:");
        
        for(Employee e : sharkEmps){
            // "talking to strangers", but this is not a normal case
            if (e.getBankAccount().balance()!=-1){
                System.out.println("Current salary: " + Double.toString(e.getBankAccount().balance()));
            } else {
                System.out.println("Balance Operation was denied");
                break;
            }
                
        }

        System.out.println("\nAfter payment:");
        shark.paySalaries(1); 
        
        for(Employee e : sharkEmps){ 
            e.getBankAccount().withdraw(500);
            if (e.getBankAccount().balance()!=-1){
                System.out.println("Current salary: " + Double.toString(e.getBankAccount().balance()));
            } else {
                System.out.println("Balance Operation was denied");
                break;
            }
        }
    }
}