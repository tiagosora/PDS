package Ex3;
public class Book {
    private String title, author;
    private int isbn, year;
    private State state;
    public Book(String title, String author, int isbn, int year) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.year = year;
        this.state = new Inventory();
    }
    public String getAuthor() {
        return author;
    }
    public State getState() {
        return state;
    }
    public String getTitle() {
        return title;
    }
    public void setnewState(State s) {
        this.state = s;
    }

    public void register() {
        this.state.register(this);
    }
    public void request() {
        this.state.request(this);
    }
    public void refund() {
        this.state.refund(this);
    }
    public void reserve() {
        this.state.reserve(this);
    }
    public void cancelReservation() {
        this.state.cancelReservation(this);
    }
}