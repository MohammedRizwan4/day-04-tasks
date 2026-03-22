public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Add items
        cart.addItem("Laptop",     1200.00, 1);
        cart.addItem("Mouse",        50.00, 2);
        cart.addItem("Keyboard",    100.00, 1);
        cart.addItem("Mouse",        50.00, 1); // should update quantity, not add new

        cart.printCart();

        // Update quantity
        System.out.println("\n--- Updating Keyboard quantity to 3 ---");
        cart.updateQuantity("Keyboard", 3);
        cart.printCart();

        // Remove item
        System.out.println("\n--- Removing Mouse ---");
        cart.removeItem("Mouse");
        cart.printCart();

        // Total items in cart
        System.out.println("\nTotal items in cart: " + cart.itemCount());
    }
}
