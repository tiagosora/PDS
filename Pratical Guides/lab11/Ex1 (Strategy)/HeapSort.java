package Ex1;

import java.util.ArrayList;

public class HeapSort implements Strategy {
    public ArrayList<MobilePhone> sort(ArrayList<MobilePhone> phones) {
        System.out.println("\nSorting with Heap sort:\n");
        for (MobilePhone p : phones) {
            System.out.println(p);
        }
        return phones;
    };
}
