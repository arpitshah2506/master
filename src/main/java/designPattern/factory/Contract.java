package designPattern.factory;

public class Contract implements Employee {
    private int salary;
    @Override
    public int getSalary() {
        return salary;
    }

    @Override
    public void setSalary(int salary) {
        this.salary = salary;
    }

}
