package Ex1;                                                   // IF OUR CLASSES AREN'T BEING FOUND, TRY REMOVING THIS LINE
public class Milk extends PortionFactory implements Portion{
    @Override
    public String toString(){ // Printable object
        return "Milk: Temperature " + this.getTemperature() + ", State " + this.getState();
    }
    @Override
    public Temperature getTemperature() { // Get the temperature of a Milk
        return Temperature.WARM;
    }
    @Override
    public State getState() { // Get the state of a Milk
        return State.Liquid;
    }
}