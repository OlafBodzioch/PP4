package pl.OlafBodzioch.ecommerce.sales;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SalesController {

    SalesFacade sales;
    public SalesController(SalesFacade sales){
        this.sales = sales;
    }

    @GetMapping("/api/current-offer")
    Offer getCurrectOffer(){
        String customerId = getCurrentCustomerId();
        return sales.getCurrentOffer(customerId);
    }

    @PostMapping("/api/accept-offer")
    ReservationDetails acceptOffer)
    {
        String CustomerId = getCurrentCustomerId();
        ReservationDetails details = sales.acceptOffer
    }

    private String getCurrentCustomerId()
    {
        return "bebek";
    }

}
