package designPattern.strategy;

public class CarPool implements Strategy {
    @Override
    public void execute() {
            System.out.println("Thanks for using car pool. You can provide your logic here");
    }
}
