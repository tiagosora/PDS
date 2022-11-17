package Ex2;
public class Contact {
    private int number;
    private String name;
    public Contact(String name, int number){
        this.name = name;
        this.number = number;
    }
    public Contact(int number, String name){
        this.name = name;
        this.number = number;
    }
    public String getName() {
        return name;
    }
    public int getNumber() {
        return number;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    @Override
    public String toString(){
        return (this.name + " " + Integer.toString(number));
    }
}