package Ex3;

import java.util.ArrayList;

public class Jeep implements Product{
    private String code;
    private String description;
    private double points;
    private ArrayList<Observer> observers;

    public Jeep(OldJeep oj) {
        String[] splitedData = oj.getData().split(";");
        this.code = splitedData[0];
        this.description = splitedData[1];
        this.points = Double.parseDouble(splitedData[2]);
        this.observers = new ArrayList<>();
    }

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String description() {
        return this.description;
    }

    @Override
    public double points() {
        return this.points;
    }

    @Override 
	public String toString(){
		return "Jeep [code="+this.code+", descr="+this.description+", points="+this.points+"]";
	}

    @Override
    public void attach(Observer observer){
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer){
        observers.remove(observer);
    }

    public ArrayList<Observer> getObservers() {
        return this.observers;
    }

}
