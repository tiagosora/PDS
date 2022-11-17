package Ex1;                                                   // IF OUR CLASSES AREN'T BEING FOUND, TRY REMOVING THIS LINE
public class PlasticBottle extends Container{
    private Portion portion; // Portion identifying the use of this type of container
    public PlasticBottle(Portion portion) { // Customized constructor
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
        return Temperature.COLD;
    }
    @Override
    public State getState() { // Get the state of the portion in this type of containers
        return State.Liquid;
    }
    @Override
    public String toString(){ // Printable Object
        return "PlasticBottle with portion: " + portion.toString();
    }
}