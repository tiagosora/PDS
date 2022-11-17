package Ex2;

import java.util.List;
import java.util.ArrayList;

public class Insurance {
    private List<Person> insurance_persons;

    public Insurance() {
        insurance_persons = new ArrayList<>();
    }

    public void regist(Person p) {
        insurance_persons.add(p);
        System.out.println("Employee " + p.getName() + " registered in Insurance with success!");
    }
}
