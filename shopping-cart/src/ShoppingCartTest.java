import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {

    ShoppingCart cart;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
    }

    // --- addItem ---

    @Test
    void shouldBeEmptyWhenCreated() {
        assertTrue(cart.isEmpty());
    }

    @Test
    void shouldAddItemToCart() {
        cart.addItem("Laptop", 1200.00, 1);
        assertFalse(cart.isEmpty());
    }

    @Test
    void shouldUpdateQuantityWhenSameItemAddedTwice() {
        cart.addItem("Mouse", 50.00, 1);
        cart.addItem("Mouse", 50.00, 2);
        assertEquals(3, cart.itemCount());
    }

    @Test
    void shouldTrackMultipleDifferentItems() {
        cart.addItem("Laptop",   1200.00, 1);
        cart.addItem("Mouse",      50.00, 2);
        cart.addItem("Keyboard",  100.00, 1);
        assertEquals(4, cart.itemCount());
    }

    // --- removeItem ---

    @Test
    void shouldRemoveItemFromCart() {
        cart.addItem("Laptop", 1200.00, 1);
        cart.removeItem("Laptop");
        assertTrue(cart.isEmpty());
    }

    @Test
    void shouldNotFailWhenRemovingNonExistentItem() {
        assertDoesNotThrow(() -> cart.removeItem("NonExistentProduct"));
    }

    // --- updateQuantity ---

    @Test
    void shouldUpdateItemQuantity() {
        cart.addItem("Keyboard", 100.00, 1);
        cart.updateQuantity("Keyboard", 5);
        assertEquals(5, cart.itemCount());
    }

    @Test
    void shouldRemoveItemWhenQuantitySetToZero() {
        cart.addItem("Mouse", 50.00, 2);
        cart.updateQuantity("Mouse", 0);
        assertTrue(cart.isEmpty());
    }

    @Test
    void shouldRemoveItemWhenQuantitySetToNegative() {
        cart.addItem("Mouse", 50.00, 2);
        cart.updateQuantity("Mouse", -1);
        assertTrue(cart.isEmpty());
    }

    // --- calculateTotal ---

    @Test
    void shouldReturnZeroTotalForEmptyCart() {
        assertEquals(0.0, cart.calculateTotal());
    }

    @Test
    void shouldCalculateTotalForSingleItem() {
        cart.addItem("Laptop", 1200.00, 2);
        assertEquals(2400.00, cart.calculateTotal());
    }

    @Test
    void shouldCalculateTotalForMultipleItems() {
        cart.addItem("Laptop",   1200.00, 1);
        cart.addItem("Mouse",      50.00, 2);
        cart.addItem("Keyboard",  100.00, 1);
        assertEquals(1400.00, cart.calculateTotal());
    }

    @Test
    void shouldRecalculateTotalAfterRemoval() {
        cart.addItem("Laptop", 1200.00, 1);
        cart.addItem("Mouse",    50.00, 1);
        cart.removeItem("Mouse");
        assertEquals(1200.00, cart.calculateTotal());
    }
}
