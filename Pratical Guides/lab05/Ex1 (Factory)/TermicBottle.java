package Ex1;                                                   // IF OUR CLASSES AREN'T BEING FOUND, TRY REMOVING THIS LINE
public class TermicBottle extends Container{
    private Portion portion; // Portion identifying the use of this type of container
    public TermicBottle(Portion portion) { // Customized constructor
        this.portion = portion;
    }
    public Portion getPortion() { // Get the selected portion in this container
        return portion;
    }
    public void setPortion(Portion portion) { // Set a new portion for this container
        this.portion = portion;
    }
    @Override
    public Temperature getTemperature() { // Get the temperature of the portion in this type of containers
        return Temperature.WARM;
    }
    @Override
    public State getState() { // Get the state of the portion in this type of containers
        return State.Liquid;
    }
    @Override
    public String toString(){ // Printable Object
        return "TermicBottle with portion: " + portion.toString();
    }
}