package Ex3;
import java.util.Collection;
public class RemoveCommand implements Command {
    private Collection collection;
    private int consecutiveCalls;
    private Object lastRemove;
    public RemoveCommand(Collection collection) {
        this.collection =  collection;
    }
    @Override
    public void resetCO() {
        this.consecutiveCalls = 0;
    }
    @Override
    public boolean execute(Object element) {
        if (this.collection.remove(element)){
            this.lastRemove = element;
            this.consecutiveCalls += 1;
            return true;
        }
        return false;
    }
    @Override
    public boolean undo() {
        if (this.consecutiveCalls > 0){
            this.consecutiveCalls -= 1;
            return this.collection.add(lastRemove);
        } else {
            System.out.println("\nCouldn't undo command remove.");
            return false;
        }
    }
}