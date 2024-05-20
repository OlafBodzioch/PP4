package pl.OlafBodzioch.ecommerce.sales;

public class SalesFacade {

    private InMemoryCartStorage cartStorage;

    public void addToCart(String customerId, String productId){
        Cart cart = loadCartForCustomer(customerId);
        cart.addProduct(productId);
    }

    private Cart loadCartForCustomer(String customerId){
        return cartStorage.findByCustomerId(customerId).
                orElse(Cart.empty());
    }

    public Offer getCurrentOffer(String customerId) {

        return  new Offer();

    }

    public ReservationDetails acceptOffer(String customerId){
        return new ReservationDetails();
    }



}
