package Ex3;


public class Customer {
    private String name;
    private Department dept;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDepartment(Department dept) {
        this.dept = dept;
    }

    public Department getDepartment() {
        return dept;
    }
}
