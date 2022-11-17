package Ex3;

public class Main {
    public static void main(String args[]) {
        CustomerCare care = new CustomerCare();

        Customer Paulinho = new Customer("Paulinho");
        Customer Sora = new Customer("Sora");

        care.reportProblem(Paulinho, "Please check screen pixels.");
        care.getSupport(Paulinho);
        care.reportProblem(Sora, "My laptop sounds like a plane when I'm playing.");
        care.getSupport(Sora);
    }
}
