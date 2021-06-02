package designPattern.strategy;

public class Factory {
    public static Strategy createInstance(int distance) {
        if (distance > 5) {
            return new BusTravel();
        } else {
            return new CarPool();
        }
    }
}
