package Ex1;                                                   // IF OUR CLASSES AREN'T BEING FOUND, TRY REMOVING THIS LINE
public abstract class Container implements Portion{
    public static Container create(Portion portion) {
        // Initial escape case
        if(portion == null) return null;
        // List of possible Containers (order is irelevante, because theren't portions with the same atributes)
        Container[] possibleContainers = new Container[] {new PlasticBottle(portion), new TermicBottle(portion), new Tupperware(portion), new PlasticBag(portion)};
        // Return the object
        for (Container container : possibleContainers){
            // Check which container matchs the Portion atributes
            if(container.getTemperature().equals(portion.getTemperature()) && container.getState().equals(portion.getState())){
                return container;
            }
        }
        // Escape case
        return null;
    }
}