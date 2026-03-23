public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        CartPrinter printer = new CartPrinter();

        cart.addItem("Laptop",   1200.00, 1);
        cart.addItem("Mouse",      50.00, 2);
        cart.addItem("Keyboard",  100.00, 1);
        cart.addItem("Mouse",      50.00, 1);
        printer.print(cart);

        System.out.println("\n--- Updating Keyboard quantity to 3 ---");
        cart.updateQuantity("Keyboard", 3);
        printer.print(cart);

        System.out.println("\n--- Removing Mouse ---");
        cart.removeItem("Mouse");
        printer.print(cart);

        System.out.println("\nTotal items in cart: " + cart.itemCount());
    }
}
