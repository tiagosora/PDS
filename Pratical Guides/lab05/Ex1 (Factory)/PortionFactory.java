package Ex1;                                                   // IF OUR CLASSES AREN'T BEING FOUND, TRY REMOVING THIS LINE
import Ex1.Portion.Temperature;                                // AND THE "EX1." IN THESE TWO LINES
import Ex1.Portion.State;
public class PortionFactory{
    private static String fruitName = "Orange"; // String to save the DEFAULT case for FruitJuice.fruitString
    public static Portion create(String food, Temperature temp){
        // List of possible Portions (order is irelevante, because theren't portions with the same atributes)
        Portion[] possiblePortions = new Portion[] { new Milk(), new FruitJuice(fruitName), new Tuna(), new Pork()};
        // Check which is state we are working with
        Portion.State state;
        if(food.equals("Beverage")){ // Beverage -> Liquid
            state = State.Liquid;
        } else if(food.equals("Meat")){ // Meat -> Solid
            state = State.Solid;
        } else { // Case the state is not identifiable
            System.out.printf("This type of food was not identified: %s", food);
            return null;
        }
        // Return the object
        for (Portion portion : possiblePortions){
            // Check which portion matchs the state and temperature selected
            if(portion.getTemperature().equals(temp) && portion.getState().equals(state)){
                return portion;
            }
        }
        // Escape case
        return null;
    }
    public static Portion create(String food, Temperature temp, String fruitNameCreate){ // In case there's the use of a third argument
        fruitName = fruitNameCreate;                                                     // using create, to set the type of fruit 
        return create(food, temp);                                                       // in the FruitJuice (fruiName)
    }
}