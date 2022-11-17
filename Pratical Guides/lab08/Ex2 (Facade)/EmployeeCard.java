package Ex2;

import java.util.ArrayList;
import java.util.List;

public class EmployeeCard {
    private int ID;
    private static int count = 1;
    private static List<Person> cards;

    public EmployeeCard() {
        cards = new ArrayList<>();
    }
    
    public void CreateCard(Person p) {
        this.ID = count;
        count++;
        cards.add(p);
        System.out.println("Employee " + p.getName() + " got a card with ID " + this.ID);
    }
}
