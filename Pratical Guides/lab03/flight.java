
import java.util.ArrayList;

public class flight {
    String code;
    int numQueuesT = 0;
    int numSeatsT = 0;
    int numQueuesE = 0;
    int numSeatsE = 0;
    boolean ex = false;
    public flight(String code, int numQueuesT, int numSeatsT, ArrayList<String> listOfFlights, ArrayList<ArrayList<String>> listOfArrangements) {
       this.code = code;
       this.numQueuesT = numQueuesT;
       this.numSeatsT = numSeatsT;
       getInfo(listOfFlights);
       new booking(this.code, listOfFlights, listOfArrangements);
    }
    public flight(String code, int numQueuesT, int numSeatsT, int numQueuesE, int numSeatsE, ArrayList<String> listOfFlights, ArrayList<ArrayList<String>> listOfArrangements) {
        this.code = code;
        this.numQueuesT = numQueuesT;
        this.numSeatsT = numSeatsT;
        this.numQueuesE = numQueuesE;
        this.numSeatsE = numSeatsE;
        this.ex = true;
        getInfo(listOfFlights);
        new booking(this.code, listOfFlights, listOfArrangements);
    }
    public int getNumQueuesE() {
        return numQueuesE;
    }
    public int getNumQueuesT() {
        return numQueuesT;
    }
    public int getNumSeatsE() {
        return numSeatsE;
    }
    public int getNumSeatsT() {
        return numSeatsT;
    }
    public String getCode() {
        return code;
    }
    public void getInfo(ArrayList<String> listOfFlights) {
        listOfFlights.add(this.code);
        listOfFlights.add(String.valueOf(this.numQueuesT));
        listOfFlights.add(String.valueOf(this.numSeatsT));
        listOfFlights.add(String.valueOf(this.numQueuesE));
        listOfFlights.add(String.valueOf(this.numSeatsE));
    }
    @Override
    public String toString() {
        if (this.ex) {
            return ("Avião " + code + " com " + numQueuesE*numSeatsE + " lugares na classe executiva e " + numQueuesT*numSeatsT + " lugares na classe turística.");
        } else {
            return ("Avião " + code + " com " + numQueuesT*numSeatsT + " lugares na classe turística.");
        }
    }
}
