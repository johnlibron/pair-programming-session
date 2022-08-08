import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShoppingCartFactoryTest {

    @Test
    public void createShoppingCart() {
        final Customer customer = new Customer("John");
        final Item item = new Item("Test-Driven", 39.90);
        final ShoppingCart shoppingCart = ShoppingCartFactory.create(customer, item);
        final Item item1 = new Item("Test-Driven1", 39.90);
        assertEquals(new ShoppingCart(1L, customer, item1), shoppingCart);
    }
}
