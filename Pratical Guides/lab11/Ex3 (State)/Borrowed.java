package Ex3;
public class Borrowed implements State{
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
        book.setnewState(new Available());
    }
    @Override
    public void reserve(Book book) {
        System.out.println("Reserve - This operation can't be done, return the book!");
    }
    @Override
    public void cancelReservation(Book book) {
        System.out.println("Cancel Reservation - This operation can't be done, return the book!");
    }
    @Override
    public String toString(){
        return "Borrowed";
    }
}