import java.util.LinkedHashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<String, CartItem> items = new LinkedHashMap<>();

    public void addItem(String productName, double price, int quantity) {
        if (items.containsKey(productName)) {
            CartItem existing = items.get(productName);
            existing.setQuantity(existing.getQuantity() + quantity);
            System.out.println("Updated quantity for: " + productName);
        } else {
            items.put(productName, new CartItem(productName, price, quantity));
            System.out.println("Added to cart: " + productName);
        }
    }

    public void removeItem(String productName) {
        if (items.containsKey(productName)) {
            items.remove(productName);
            System.out.println("Removed from cart: " + productName);
        } else {
            System.out.println("Item not found: " + productName);
        }
    }

    public void updateQuantity(String productName, int quantity) {
        if (items.containsKey(productName)) {
            if (quantity <= 0) {
                removeItem(productName);
            } else {
                items.get(productName).setQuantity(quantity);
                System.out.println("Quantity updated: " + productName + " x" + quantity);
            }
        } else {
            System.out.println("Item not found: " + productName);
        }
    }

    public double calculateTotal() {
        return items.values().stream()
                .mapToDouble(CartItem::totalPrice)
                .sum();
    }

    public void printCart() {
        if (items.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }
        System.out.println("\n--- Shopping Cart ---");
        items.values().forEach(System.out::println);
        System.out.println("---------------------");
        System.out.println("Total: Rs." + calculateTotal());
    }

    public int itemCount() {
        return items.values().stream()
                .mapToInt(CartItem::getQuantity)
                .sum();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}
