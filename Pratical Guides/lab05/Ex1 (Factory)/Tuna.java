package Ex1;                                                   // IF OUR CLASSES AREN'T BEING FOUND, TRY REMOVING THIS LINE
public class Tuna extends PortionFactory implements Portion{
    @Override
    public String toString(){ // Printable object
        return "Tuna: Temperature " + this.getTemperature() + ", State " + this.getState();
    }
    @Override
    public Temperature getTemperature() { // Get the temperature of a Tuna
        return Temperature.COLD;
    }
    @Override
    public State getState() { // Get the state of a Tuna
        return State.Solid;
    }
}