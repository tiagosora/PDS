package Ex3;
public class Available implements State{
    @Override
    public void register(Book book) {
        System.out.println("Register - This operation can't be done, this book was already resgistered!");
    }
    @Override
    public void request(Book book) {
        book.setnewState(new Borrowed());
    }
    @Override
    public void refund(Book book) {
        System.out.println("Refund - This operation can't be done, request the book!");
    }
    @Override
    public void reserve(Book book) {
        book.setnewState(new Reserved());
    }
    @Override
    public void cancelReservation(Book book) {
        System.out.println("Cancel Reservation - This operation can't be done, reserve the book!");
    }
    @Override
    public String toString(){
        return "Available";
    }
}