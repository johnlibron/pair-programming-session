import java.util.Objects;

public class ShoppingCart {
    private final Long id;
    private final Customer customer;
    private final Item item;

    public ShoppingCart(Long id, Customer customer, Item item) {
        this.id = id;
        this.customer = customer;
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCart that = (ShoppingCart) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
