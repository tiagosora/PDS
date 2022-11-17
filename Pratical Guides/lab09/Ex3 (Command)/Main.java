package Ex3;
import java.util.ArrayList;
import java.util.Collection;
public class Main {
    public static void main(String[] args) {
        // Collection used to save the addictions and removes.
        Collection collection = new ArrayList<>();
        // Add the 2 main commands (add and remove, corresponding to a AddCommand and RemoveCommand)
        Command add = new AddCommand(collection);
        Command remove = new RemoveCommand(collection);
        // Set the controller for this system
        Controller controller = new Controller<>();
        // This is used to check if the collection is fully empty
        if(collection.isEmpty()){
            System.out.println("This collection is empty!");
        }
        // Firstly, we execute the commmand add 3 times to add the elements (1,2,3) in the collection
        controller.setCommand(add);
        controller.execute(1);
        controller.execute(2);
        controller.execute(3);
        System.out.println("\nPrinting collection after 3 adds (1,2,3):");
        for (Object object : collection) {
            System.out.println(object);
        }
        // The command undo is used to remove the last element added in the list.
        controller.undo();
        System.out.println("\nPrinting collection after 1 undo (add):");
        for (Object object : collection) {
            System.out.println(object);
        }
        // Now we set the command in the remote to remove and we execute it to remove the number 1
        controller.setCommand(remove);
        controller.execute(1);
        System.out.println("\nPrinting collection after 1 remove (1):");
        for (Object object : collection) {
            System.out.println(object);
        }
        // It is also able to undo its actions
        controller.undo();
        System.out.println("\nPrinting collection after 1 undo (remove):");
        for (Object object : collection) {
            System.out.println(object);
        }
        // However, if we set a new command, it is not able to undo any executions before they are made
        controller.setCommand(add);
        controller.undo();
        controller.setCommand(remove);
        controller.undo();
    }
}