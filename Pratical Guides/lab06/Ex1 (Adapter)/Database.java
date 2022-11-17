package Ex1;
import java.util.*;

class Database {    // Data elements
    private Vector<Employee> employees; // Stores the employees
    public Database() {
        employees = new Vector<>();
    }
    public boolean addEmployee(Employee employee) {
        // Code to add employee
        if (!employees.contains(employee)) {
            employees.add(employee);
            return true;
        }
        return false;
    }
    public void deleteEmployee(long emp_num) {
        // Code to delete employee
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmpNum() == emp_num)
                this.employees.remove(i);
        }
    }
    public Employee[] getAllEmployees() {
        // Code to retrieve collection
        Employee[] new_emp = new Employee[employees.size()];
        for (int i = 0; i < employees.size(); i++) {
            new_emp[i] = employees.get(i);
        }
        return new_emp;
    }
}