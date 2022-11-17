package Ex1;                                                   // IF OUR CLASSES AREN'T BEING FOUND, TRY REMOVING THIS LINE
public class Tupperware extends Container{
    private Portion portion; // Portion identifying the use of this type of container
    public Tupperware(Portion portion) { // Customized constructor
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
        return State.Solid;
    }
    @Override
    public String toString(){ // Printable Object
        return "Tupperware with portion: " + portion.toString();
    }
}