package Ex3;
public interface State {
    public void register(Book book);
    public void request(Book book);
    public void refund(Book book);
    public void reserve(Book book);
    public void cancelReservation(Book book);
}