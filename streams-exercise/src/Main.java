import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
            new Order("ORD-001", "Ayaan",  "Laptop",   1200.00, "PAID"),
            new Order("ORD-002", "Sana",   "Phone",     800.00, "PENDING"),
            new Order("ORD-003", "Rizwan", "Tablet",    450.00, "PAID"),
            new Order("ORD-004", "Imran",  "Monitor",   300.00, "CANCELLED"),
            new Order("ORD-005", "Sameer", "Keyboard",  100.00, "PAID"),
            new Order("ORD-006", "Ayaan",  "Mouse",      50.00, "PENDING"),
            new Order("ORD-007", "Sana",   "Headphones", 200.00, "PAID")
        );

        // 1. Print all orders
        System.out.println("=== All Orders ===");
        orders.stream()
              .forEach(System.out::println);

        // 2. Get only PAID orders
        System.out.println("\n=== Paid Orders ===");
        orders.stream()
              .filter(o -> o.getStatus().equals("PAID"))
              .forEach(System.out::println);

        // 3. Total revenue from PAID orders
        double totalRevenue = orders.stream()
              .filter(o -> o.getStatus().equals("PAID"))
              .mapToDouble(Order::getAmount)
              .sum();
        System.out.println("\n=== Total Revenue ===");
        System.out.println("Rs. " + totalRevenue);

        // 4. Get list of customer names who have PAID orders (no duplicates)
        System.out.println("\n=== Customers with Paid Orders ===");
        orders.stream()
              .filter(o -> o.getStatus().equals("PAID"))
              .map(Order::getCustomerName)
              .distinct()
              .forEach(System.out::println);

        // 5. Find most expensive order
        System.out.println("\n=== Most Expensive Order ===");
        orders.stream()
              .max((o1, o2) -> Double.compare(o1.getAmount(), o2.getAmount()))
              .ifPresent(System.out::println);

        // 6. Count orders by status
        System.out.println("\n=== Orders by Status ===");
        orders.stream()
              .collect(Collectors.groupingBy(Order::getStatus, Collectors.counting()))
              .forEach((status, count) -> System.out.println(status + ": " + count));

        // 7. Get all product names sorted alphabetically
        System.out.println("\n=== Products (Sorted) ===");
        orders.stream()
              .map(Order::getProduct)
              .sorted()
              .forEach(System.out::println);
    }
}
