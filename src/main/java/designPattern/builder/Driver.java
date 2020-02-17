package designPattern.builder;

public class Driver {

    public static void main(String[] args) {
        PurchaseOrder purchaseOrder = new PurchaseOrder.PurchaseOrderBuilder().withBillingAddress("Gujarat").withShippingAddress("Pune").withId(5).withLines(5).build();
        PurchaseOrder anotherPurchaseOrder = new PurchaseOrder.PurchaseOrderBuilder().withBillingAddress("Bangalore").withShippingAddress("Pune").withId(3).withLines(7).build();

        System.out.println(purchaseOrder);
        System.out.println(anotherPurchaseOrder);
    }
}
