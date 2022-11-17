package Ex1;

import java.util.ArrayList;

public class Main {
    public static void main(String args[]) {
        ArrayList<MobilePhone> phones = new ArrayList<>();
        phones.add(new MobilePhone("Xiaomi 9S", "Processor 1000", "359.99", "16", "48"));
        phones.add(new MobilePhone("Samsung Galaxy 3", "Processor XPTO", "499.99", "32", "48"));
        phones.add(new MobilePhone("iPhone X", "Processor apple", "899.99", "16", "52"));
        phones.add(new MobilePhone("Nokia 3310", "Processor ultra", "59.99", "2", "2"));

        Context context = new Context(new HeapSort());
        context.sort(phones);

        context.setStrategy(new MergeSort());
        context.sort(phones);

        context.setStrategy(new SelectionSort());
        context.sort(phones);
    }
} 
