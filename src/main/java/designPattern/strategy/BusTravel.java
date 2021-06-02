package designPattern.strategy;

public class BusTravel implements Strategy {
    @Override
    public void execute() {
        System.out.println("Thanks for travelling by bus");
    }
}
