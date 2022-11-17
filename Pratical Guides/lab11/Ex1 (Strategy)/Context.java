package Ex1;

import java.util.ArrayList;

public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public ArrayList<MobilePhone> sort(ArrayList<MobilePhone> phones) {
        return this.strategy.sort(phones);
    };

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
