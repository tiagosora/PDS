package Ex3;

public class ScreenDepartment extends Department {
    public ScreenDepartment() {
        super("Screen Department");
    } 

    public void technicalSupport() {
        System.out.println("The " + this.getName() + " will help you resolve your screen related problems.");
    }
}
