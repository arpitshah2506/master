package designPattern.factory;

public class Factory {
    public static Employee createInstance(EmployeeType employeeType) {
        if (employeeType.equals(EmployeeType.CONTRACT)) {
            return new Contact();
        } else {
            return new Regaular();
        }
    }
}
