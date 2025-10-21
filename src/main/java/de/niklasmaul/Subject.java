package de.niklasmaul;

import java.util.ArrayList;

public abstract class Subject {
    private ArrayList<IObserver> observer = new ArrayList<>();

    public void subscribe(IObserver observer) {
        this.observer.add(observer);
    }

    public void unsubscribe(IObserver observer) {
        this.observer.remove(observer);
    }

    public void sendNotification() {
        for(IObserver observer : this.observer) {
            observer.update();
        }
    }

}
