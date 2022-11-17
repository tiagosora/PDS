 // to complete
 public class Lab05ex2 {
    public static void main(String[] args) {
        CakeMaster cakeMaster = new CakeMaster();

        CakeBuilder chocolate = new ChocolateCakeBuilder();
        cakeMaster.setCakeBuilder(chocolate);
        cakeMaster.createCake("Congratulations");       // 1 cake layer
        Cake cake = cakeMaster.getCake();
        System.out.println("Your cake is ready: " + cake);
        
        CakeBuilder sponge = new SpongeCakeBuilder();
        cakeMaster.setCakeBuilder(sponge);
        cakeMaster.createCake(Shape.Square, 2, "Well done");    // squared, 2 layers
        cake = cakeMaster.getCake();
        System.out.println("Your cake is ready: " + cake);
        
        CakeBuilder yogurt = new YogurtCakeBuilder();
        cakeMaster.setCakeBuilder(yogurt);
        cakeMaster.createCake(3, "The best");           // 3 cake layers
        cake = cakeMaster.getCake();
        System.out.println("Your cake is ready: " + cake);

        // you should add here other example(s) of CakeBuilder
        // Coconut cake with Chocolate and Straw_Berries cream and more coconut topping
        CakeBuilder coconut = new CoconutCakeBuilder();
        cakeMaster.setCakeBuilder(coconut);
        cakeMaster.createCake(Shape.Triangle, 2, "Happy Birthday");    // triangular, 2 layers
        cake = cakeMaster.getCake();
        System.out.println("Your cake is ready: " + cake);

    }
}