public class CartPrinter {

    public void print(ShoppingCart cart) {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }
        System.out.println("\n--- Shopping Cart ---");
        cart.getItems().values().forEach(System.out::println);
        System.out.println("---------------------");
        System.out.println("Total: Rs." + cart.calculateTotal());
    }
}
