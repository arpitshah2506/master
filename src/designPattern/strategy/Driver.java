package designPattern.strategy;

public class Driver {

    public static final int DISTANCE_TO_TRAVEL = 4; //change values to have different strategy

    public static void main(String[] args) {
        Factory.createInstance(DISTANCE_TO_TRAVEL).execute();
    }
}
