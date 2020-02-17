package designPattern.builder;

public class PurchaseOrder {
    private int id;
    private int total;
    private int lines;
    private String shippingAddress;
    private String billingAddress;

    public PurchaseOrder(int id, int total, int lines, String shippingAddress, String billingAddress) {
        this.id = id;
        this.total = total;
        this.lines = lines;
        this.shippingAddress = shippingAddress;
        this.billingAddress = billingAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getLines() {
        return lines;
    }

    public void setLines(int lines) {
        this.lines = lines;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public static class PurchaseOrderBuilder {
        private int id;
        private int total;
        private int lines;
        private String shippingAddress;
        private String billingAddress;

        public PurchaseOrderBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public PurchaseOrderBuilder withTotal(int total) {
            this.total = total;
            return this;
        }

        public PurchaseOrderBuilder withLines(int lines) {
            this.lines = lines;
            return this;
        }

        public PurchaseOrderBuilder withShippingAddress(String shippingAddress) {
            this.shippingAddress = shippingAddress;
            return this;
        }

        public PurchaseOrderBuilder withBillingAddress(String billingAddress) {
            this.billingAddress = billingAddress;
            return this;
        }

        public PurchaseOrder build() {
            return new PurchaseOrder(id, total, lines, shippingAddress, billingAddress);
        }
    }

    @Override
    public String toString() {
        return "PurchaseOrder{" +
                "id=" + id +
                ", total=" + total +
                ", lines=" + lines +
                ", shippingAddress='" + shippingAddress + '\'' +
                ", billingAddress='" + billingAddress + '\'' +
                '}';
    }
}
