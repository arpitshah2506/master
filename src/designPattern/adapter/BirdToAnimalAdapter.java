package designPattern.adapter;

class BirdToAnimalAdapter implements Bird{
    private Animal animal;
    BirdToAnimalAdapter(Animal animal) {
        this.animal = animal;
    }
    @Override
    public void fly() {
        this.animal.run();
    }
}
