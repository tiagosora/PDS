// package Ex1;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class Ex1_main {
    public static void main(String args[]) {
        char[] c = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};
        VectorGeneric<Character> vector = new VectorGeneric();

        for (char e : c)
            vector.addElem(e);

        System.out.println("\nITERATOR TEST\n");
        Iterator<Character> normalIterator = vector.Iterator();

        while (normalIterator.hasNext())
            System.out.println("Element: " + normalIterator.next());

        System.out.println("\nLIST ITERATOR TEST\n");
        ListIterator<Character> normalListIterator = vector.listIterator();

        System.out.println("\nFORWARD ITERATION");
        while (normalListIterator.hasNext())
            System.out.println("Next index: " + normalListIterator.nextIndex() + " Next element: " + normalListIterator.next());

        System.out.println("\nBACKWARDS ITERATION");
        while (normalListIterator.hasPrevious())
            System.out.println("Previous index: " + normalListIterator.previousIndex() + " Previous element: " + normalListIterator.previous());

        System.out.println("\nLIST ITERATOR W/ SPECIFIED INDEX TEST\n");
        ListIterator<Character> indexedListIterator = vector.listIterator(4);

        System.out.println("\nFORWARD ITERATION");
        while (indexedListIterator.hasNext())
            System.out.println("Next index: " + indexedListIterator.nextIndex() + " Next element: " + indexedListIterator.next());

        System.out.println("\nBACKWARDS ITERATION");
        while (indexedListIterator.hasPrevious())
            System.out.println("Previous index: " + indexedListIterator.previousIndex() + " Previous element: " + indexedListIterator.previous());

        System.out.println("\nLIST ITERATOR W/ SPECIFIED INDEX and NORMAL INTERATOR TEST\n");
        indexedListIterator = vector.listIterator(4);
        normalIterator = vector.Iterator();

        while (indexedListIterator.hasNext()) {
            System.out.println("List --> Next index: " + indexedListIterator.nextIndex() + " Next element: " + indexedListIterator.next());
            System.out.println("Normal --> Element: " + normalIterator.next());
        }
    }
}
