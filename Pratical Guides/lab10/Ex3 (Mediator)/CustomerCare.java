package Ex3;

import java.util.Date;

public class CustomerCare implements CustomerCareInterface {
    @Override   
    public void reportProblem(Customer customer, String message) {
        System.out.println("[" + customer.getName() + " on " + new Date().toString() + "]: " + message);
        if (message.contains("screen"))
            customer.setDepartment(new ScreenDepartment());
        else if (message.contains("sound"))
            customer.setDepartment(new SoundsDepartment());
        else
            System.err.println("Sorry, we don't have a service to resolve your problem!");
    }

    @Override
    public void getSupport(Customer customer) {
        customer.getDepartment().technicalSupport();
    }
}
