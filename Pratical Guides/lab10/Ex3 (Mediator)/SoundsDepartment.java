package Ex3;

public class SoundsDepartment extends Department {
    public SoundsDepartment() {
        super("Sounds Department");
    } 

    public void technicalSupport() {
        System.out.println("The " + this.getName() + " will help you discover why your laptop makes strange noises.");
    }
}
