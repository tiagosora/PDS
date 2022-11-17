package Ex3;
public class Inventory implements State{
    @Override
    public void register(Book book) {
        book.setnewState(new Available());
    }
    @Override
    public void request(Book book) {
        System.out.println("Request - This operation can't be done, register the book!");
    }
    @Override
    public void refund(Book book) {
        System.out.println("Refund - This operation can't be done, register the book!");
    }
    @Override
    public void reserve(Book book) {
        System.out.println("Reserve - This operation can't be done, register the book!");
    }
    @Override
    public void cancelReservation(Book book) {
        System.out.println("Cancel Reservation - This operation can't be done, register the book!");
    }
    @Override
    public String toString(){
        return "Inventory";
    }
}