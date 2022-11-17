package Ex3;

import java.util.ArrayList;

public interface Product {
	String code();
	String description();
	double points();
	void attach(Observer observer);
	void removeObserver(Observer observer);
	ArrayList<Observer> getObservers();
}
