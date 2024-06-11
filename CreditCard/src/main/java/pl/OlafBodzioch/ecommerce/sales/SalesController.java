package pl.OlafBodzioch.ecommerce.sales;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import pl.OlafBodzioch.ecommerce.sales.offering.Offer;
import pl.OlafBodzioch.ecommerce.sales.reservation.ReservationDetails;

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
    ReservationDetails acceptOffer(AcceptOfferRequest acceptOfferRequest)
    {
        String customerId = getCurrentCustomerId();
        ReservationDetails details = sales.acceptOffer(customerId, acceptOfferRequest);
        return details;

    }

    @PostMapping("/api/add-to-cart/{productId}")
    void addToCart(@PathVariable String productId) {
        String customerId = getCurrentCustomerId();
        sales.addToCart(customerId,productId);
    }


    private String getCurrentCustomerId()
    {
        return "sumio";
    }


}