package designPattern.factory;

public class Factory {
    public static Employee createInstance(EmployeeType employeeType) {
        if (employeeType.equals(EmployeeType.CONTRACT)) {
            return new Contract();
        } else {
            return new Regaular();
        }
    }
}
