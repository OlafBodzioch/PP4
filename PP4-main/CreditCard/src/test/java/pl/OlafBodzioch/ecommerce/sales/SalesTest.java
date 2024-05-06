package pl.OlafBodzioch.ecommerce.sales;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class SalesTest {
    
    @Test
    void itShowsOffer(){
        SalesFacade status = theresIsSalesFacade();
        String customerId = thereIsExampleCustomer("Bebek");

        Offer offer = sales.getCurrentOffer(customerId);
    }

    private String thereIsExampleCustomer(String id) {
        return id;
    }

    private SalesFacade theresIsSalesFacade() {
        return new SalesFacade();
    }

    @Test
    void itAllowsToAddProductToCart(){

    }
    
    @Test
    void itRemovesProductFromCart(){

    }
    
    
}
