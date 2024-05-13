package pl.OlafBodzioch.ecommerce.sales;

import org.assertj.core.api.BigDecimalAssert;
import org.junit.jupiter.api.Test;

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

    private String thereIsExampleCustomer(String id) {
        return id;
    }

    private SalesFacade theresIsSalesFacade() {
        return new SalesFacade();
    }

    @Test
    void itAllowsToAddProductToCart(){}
    
    @Test
    void itRemovesProductFromCart(){

    }
    
    
}
