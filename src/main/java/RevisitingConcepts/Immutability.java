package RevisitingConcepts;

public class Immutability {
    public static void main(String[] args) {
        Address address = new Address();
        address.setAddressId(10);
        address.setStreet("Vasna");

        A a = new A(10, address);

        System.out.println(a.getAddress());
        address.setAddressId(20);
        System.out.println(a.getAddress());
    }
}

final class A {
    final int i;
    final Address address;

    A(int i, Address address) {
        this.i = i;
        this.address = new Address();
        this.address.setStreet(address.getStreet());
        this.address.setAddressId(address.getAddressId());
    }

    public int getI() {
        return i;
    }

    public Address getAddress() {
        return address;
    }
}

class Address {
    private int addressId;
    private String street;

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", street='" + street + '\'' +
                '}';
    }
}