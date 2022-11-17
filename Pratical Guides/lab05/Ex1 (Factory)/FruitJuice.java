package Ex1;                                                   // IF OUR CLASSES AREN'T BEING FOUND, TRY REMOVING THIS LINE
public class FruitJuice extends PortionFactory implements Portion{
    private String fruitString; // Possible third argument in the Portion constructor (if it doesnt exist: by DEFAULT: "Orange")
    public FruitJuice(String fruitString){ // Customized constructor
        this.fruitString = fruitString;
    }
    public String getFruitString() { // Get the selected fruit (fruitString)
        return fruitString;
    }
    public void setFruitString(String fruitString) { // Set a new fruit (fruitString) for this FruitJuice
        this.fruitString = fruitString;
    }
    @Override
    public String toString(){ // Printable object
        return "FruitJuice: " + fruitString + ", Temperature " + this.getTemperature() + ", State " + this.getState();
    }
    @Override
    public Temperature getTemperature() { // Get the temperature of a FruitJuice
        return Temperature.COLD;
    }
    @Override
    public State getState() { // Get the state of a FruitJuice
        return State.Liquid;
    }
}