package Ex2;

import java.util.ArrayList;
import java.util.List;

public class SocialSecurity {
    private List<Person> ss_persons;

    public SocialSecurity() {
        ss_persons = new ArrayList<>();
    }

    public void regist(Person p) {
        ss_persons.add(p);
        System.out.println("Employee " + p.getName() + " registered in Social Security with success!");
    }
}
