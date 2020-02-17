package designPattern.observer;

import java.util.Observable;
import java.util.Observer;

public class RunrateObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println(arg);
    }
}
