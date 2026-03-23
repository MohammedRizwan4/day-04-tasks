import java.util.List;
import java.util.stream.Collectors;

public class OrderAnalytics {
    private final List<Order> orders;

    public OrderAnalytics(List<Order> orders) {
        this.orders = orders;
    }

    public void printAllOrders() {
        System.out.println("=== All Orders ===");
        orders.forEach(System.out::println);
    }

    public void printPaidOrders() {
        System.out.println("\n=== Paid Orders ===");
        orders.stream()
              .filter(o -> o.getStatus().equals(Order.STATUS_PAID))
              .forEach(System.out::println);
    }

    public void printTotalRevenue() {
        double totalRevenue = orders.stream()
              .filter(o -> o.getStatus().equals(Order.STATUS_PAID))
              .mapToDouble(Order::getAmount)
              .sum();
        System.out.println("\n=== Total Revenue ===");
        System.out.println("Rs. " + totalRevenue);
    }

    public void printCustomersWithPaidOrders() {
        System.out.println("\n=== Customers with Paid Orders ===");
        orders.stream()
              .filter(o -> o.getStatus().equals(Order.STATUS_PAID))
              .map(Order::getCustomerName)
              .distinct()
              .forEach(System.out::println);
    }

    public void printMostExpensiveOrder() {
        System.out.println("\n=== Most Expensive Order ===");
        orders.stream()
              .max((o1, o2) -> Double.compare(o1.getAmount(), o2.getAmount()))
              .ifPresent(System.out::println);
    }

    public void printOrderCountByStatus() {
        System.out.println("\n=== Orders by Status ===");
        orders.stream()
              .collect(Collectors.groupingBy(Order::getStatus, Collectors.counting()))
              .forEach((status, count) -> System.out.println(status + ": " + count));
    }

    public void printProductsSorted() {
        System.out.println("\n=== Products (Sorted) ===");
        orders.stream()
              .map(Order::getProduct)
              .sorted()
              .forEach(System.out::println);
    }
}
