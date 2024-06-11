package pl.OlafBodzioch.ecommerce.sales;

import org.junit.jupiter.api.Test;
import pl.OlafBodzioch.ecommerce.infastructure.PayUPaymentGw;
import pl.OlafBodzioch.ecommerce.sales.cart.CartStorage;
import pl.OlafBodzioch.ecommerce.sales.cart.InMemoryCartStorage;
import pl.OlafBodzioch.ecommerce.sales.offering.Offer;
import pl.OlafBodzioch.ecommerce.sales.offering.OfferCalculator;
import pl.OlafBodzioch.ecommerce.sales.reservation.ReservationRepository;
import pl.OlafBodzioch.ecommerce.sales.reservation.SpyPaymentGateway;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class SalesTest {
    
    @Test
    void itShowsOffer(){
        SalesFacade sales = theresIsSalesFacade();
        String customerId = thereIsExampleCustomer("Bebek");

        Offer offer = sales.getCurrentOffer(customerId);

        assertEquals(0, offer.getItemsCount());
        assertEquals(BigDecimal.ZERO, offer.getTotal());
    }

    private SalesFacade theresIsSalesFacade() {
        return new SalesFacade(
                new InMemoryCartStorage(),
                new OfferCalculator()
        );
    }

    private String thereIsExampleCustomer(String id) {
        return id;
    }

    private SalesFacade theresIsSales() {
        return new SalesFacade(
                new CartStorage(),
                new OfferCalculator(),
                new SpyPaymentGateway(),
                new ReservationRepository()
        );
    }

    @Test
    void itAllowsToAddProductToCart(){}
    
    @Test
    void itRemovesProductFromCart(){

    }
    
    
}
