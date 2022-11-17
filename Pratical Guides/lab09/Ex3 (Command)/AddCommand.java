package Ex3;
import java.util.Collection;
public class AddCommand implements Command {
    private Collection collection;
    private int consecutiveCalls;
    private Object lastAddiction;
    public AddCommand(Collection collection) {
        this.collection =  collection;
    }
    @Override
    public void resetCO() {
        this.consecutiveCalls = 0;
    }
    @Override
    public boolean execute(Object element) {
        if (this.collection.add(element)){
            this.lastAddiction = element;
            this.consecutiveCalls += 1;
            return true;
        }
        return false;
    }
    @Override
    public boolean undo() {
        if (this.consecutiveCalls > 0){
            this.consecutiveCalls -= 1;
            return this.collection.remove(lastAddiction);
        } else {
            System.out.println("\nCouldn't undo command add.");
            return false;
        }
    }
}