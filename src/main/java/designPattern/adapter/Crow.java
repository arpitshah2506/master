package designPattern.adapter;

public class Crow implements Bird {
    @Override
    public void fly() {
        System.out.println("I am crow");
    }
}
