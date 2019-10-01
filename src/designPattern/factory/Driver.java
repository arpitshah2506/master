package designPattern.factory;

public class Driver {
    public static void main(String[] args) {
        Employee contractEmployee = Factory.createInstance(EmployeeType.CONTRACT);
        Employee regularEmployee = Factory.createInstance(EmployeeType.REGULAR);

        contractEmployee.setSalary(2000);
        regularEmployee.setSalary(2000);

        //2000 40000
        System.out.println(contractEmployee.getSalary() + " " + regularEmployee.getSalary());
    }
}
