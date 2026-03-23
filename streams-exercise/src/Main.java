import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
            new Order("ORD-001", "Ayaan",  "Laptop",      1200.00, Order.STATUS_PAID),
            new Order("ORD-002", "Sana",   "Phone",        800.00, Order.STATUS_PENDING),
            new Order("ORD-003", "Rizwan", "Tablet",       450.00, Order.STATUS_PAID),
            new Order("ORD-004", "Imran",  "Monitor",      300.00, Order.STATUS_CANCELLED),
            new Order("ORD-005", "Sameer", "Keyboard",     100.00, Order.STATUS_PAID),
            new Order("ORD-006", "Ayaan",  "Mouse",         50.00, Order.STATUS_PENDING),
            new Order("ORD-007", "Sana",   "Headphones",   200.00, Order.STATUS_PAID)
        );

        OrderAnalytics analytics = new OrderAnalytics(orders);
        analytics.printAllOrders();
        analytics.printPaidOrders();
        analytics.printTotalRevenue();
        analytics.printCustomersWithPaidOrders();
        analytics.printMostExpensiveOrder();
        analytics.printOrderCountByStatus();
        analytics.printProductsSorted();
    }
}
