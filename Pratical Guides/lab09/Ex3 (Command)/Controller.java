package Ex3;
public class Controller<T> {
    private Command<T> command;
    
    public void setCommand(Command<T> command) {
        this.command = command;
        command.resetCO();
    }
    public boolean execute(T element) {
        return command.execute(element);
    }

    public boolean undo(){
        return command.undo();
    }
}