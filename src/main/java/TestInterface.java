interface interfaceA {
    default String getName() {
        return "Hello";
    }
}

interface interfaceB {
    default String getName() {
        return "Moto";
    }
}

public class TestInterface implements interfaceA, interfaceB {
    public static void main(String[] args) {
        TestInterface a = new TestInterface();
        System.out.println(a.getName());
    }

    @Override
    public String getName() {
        return interfaceB.super.getName();
    }
}