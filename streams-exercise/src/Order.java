public class Order {
    public static final String STATUS_PAID      = "PAID";
    public static final String STATUS_PENDING   = "PENDING";
    public static final String STATUS_CANCELLED = "CANCELLED";

    private String id;
    private String customerName;
    private String product;
    private double amount;
    private String status;

    public Order(String id, String customerName, String product, double amount, String status) {
        this.id = id;
        this.customerName = customerName;
        this.product = product;
        this.amount = amount;
        this.status = status;
    }

    public String getId() { return id; }
    public String getCustomerName() { return customerName; }
    public String getProduct() { return product; }
    public double getAmount() { return amount; }
    public String getStatus() { return status; }

    @Override
    public String toString() {
        return id + " | " + customerName + " | " + product + " | " + amount + " | " + status;
    }
}
