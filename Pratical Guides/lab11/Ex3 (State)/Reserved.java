package Ex3;
public class Reserved implements State{
    @Override
    public void register(Book book) {
        System.out.println("Register - This operation can't be done, this book was already resgistered!");
    }
    @Override
    public void request(Book book) {
        System.out.println("Request - This operation can't be done, return the book!");
    }
    @Override
    public void refund(Book book) {
        System.out.println("Refund - This operation can't be done, return the book!");
    }
    @Override
    public void reserve(Book book) {
        System.out.println("Reserve - This operation can't be done, return the book!");
    }
    @Override
    public void cancelReservation(Book book) {
        book.setnewState(new Available());
    }
    @Override
    public String toString(){
        return "Reserved";
    }
}