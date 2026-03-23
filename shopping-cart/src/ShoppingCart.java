import java.util.LinkedHashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<String, CartItem> items = new LinkedHashMap<>();

    public void addItem(String productName, double price, int quantity) {
        if (items.containsKey(productName)) {
            CartItem existing = items.get(productName);
            existing.setQuantity(existing.getQuantity() + quantity);
        } else {
            items.put(productName, new CartItem(productName, price, quantity));
        }
    }

    public void removeItem(String productName) {
        items.remove(productName);
    }

    public void updateQuantity(String productName, int quantity) {
        if (!items.containsKey(productName)) return;
        if (quantity <= 0) {
            removeItem(productName);
        } else {
            items.get(productName).setQuantity(quantity);
        }
    }

    public double calculateTotal() {
        return items.values().stream()
                .mapToDouble(CartItem::totalPrice)
                .sum();
    }

    public int itemCount() {
        return items.values().stream()
                .mapToInt(CartItem::getQuantity)
                .sum();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public Map<String, CartItem> getItems() {
        return items;
    }
}
