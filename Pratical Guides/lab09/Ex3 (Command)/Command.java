package Ex3;
public interface Command<T> {
    public void resetCO();
    public boolean execute(T element);
    public boolean undo();
}