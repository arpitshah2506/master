package designPattern.observer;

import java.util.Observer;

public class Driver {
    public static void main(String[] args) {
        Observer observer = new RunrateObserver();
        CricketScoreObservable observable = new CricketScoreObservable();

        observable.addObserver(observer);
        observable.stateChanged(50);
    }
}
