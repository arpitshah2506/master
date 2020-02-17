package designPattern.factory;

public class Regaular implements Employee {
    private int salary;
    @Override
    public int getSalary() {
        return salary * 2;
    }

    @Override
    public void setSalary(int salary) {
        this.salary = salary;
    }
}
