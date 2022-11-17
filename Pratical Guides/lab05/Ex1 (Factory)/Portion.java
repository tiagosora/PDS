package Ex1;                                                   // IF OUR CLASSES AREN'T BEING FOUND, TRY REMOVING THIS LINE
public interface Portion {
    public enum State {
        Solid, Liquid;
    }
    public enum Temperature {
        WARM, COLD;
    }
    public Temperature getTemperature();
    public State getState();
}