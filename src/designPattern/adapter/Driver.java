package designPattern.adapter;

public class Driver {
    public static void main(String[] args) {
        Bird crow = new Crow();
        crow.fly();

        Animal deer = new Deer();
        deer.run();

        Animal tiger = new Tiger();
        tiger.run();

        System.out.println("This weird bird will act as deer via adapter");
        Bird weird = new BirdToAnimalAdapter(deer);
        weird.fly();
    }

}
