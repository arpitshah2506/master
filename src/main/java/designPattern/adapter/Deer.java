package designPattern.adapter;

public class Deer implements Animal {
    @Override
    public void run() {
        System.out.println("I am deer, follow me");
    }
}
