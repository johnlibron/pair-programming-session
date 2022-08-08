public class ShoppingCartFactory {
    public static ShoppingCart create(Customer customer, Item item) {
        return new ShoppingCart(1L, customer, item);
    }
}
