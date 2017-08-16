package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/3/13.
 */
public class Stock {
    private double price;
    private List<Observer> observers;

    public Stock(double price) {
        observers = new ArrayList<Observer>();
        this.price = price;
    }

    private void notifyObservers() {
        for(Observer observer: observers) {
            observer.update(this.price);
        }
    }

    public void setPrice(double newPrice) {
        this.price = newPrice;

        notifyObservers();
    }

    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }
}
