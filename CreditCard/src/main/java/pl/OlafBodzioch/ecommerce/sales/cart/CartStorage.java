package pl.OlafBodzioch.ecommerce.sales.cart;

import java.util.Optional;
import java.util.Spliterator;

public class CartStorage {

    public Optional<Cart> getForCustomer(String customerId){
        return Optional.empty();
    }

    public Optional<Cart> findByCustomer(String customerId) {
        return Optional.empty();
    }

    public CartStorage() {
    }

    public Optional<Cart> loadCartForCustomer(String customerId) {
        return Optional.empty();
    }
}
