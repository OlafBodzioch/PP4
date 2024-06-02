package pl.OlafBodzioch.ecommerce.sales.reservation;

import pl.OlafBodzioch.ecommerce.sales.AcceptOfferRequest;
import pl.OlafBodzioch.ecommerce.sales.payment.PaymentDetails;
import pl.OlafBodzioch.ecommerce.sales.payment.PaymentGateway;

import java.math.BigDecimal;
import java.time.Instant;

public class Reservation {

    public static Reservation of(String reservationId, String customerId, AcceptOfferRequest acceptOfferRequest, PaymentDetails paymentDetails)
    {
        return new Reservation(

        );
    }

    public BigDecimal getTotal()
    {
        return null;
    }

    public boolean isPending()
    {
        return true;
    }

    public CustomerDetails getCustomerDetail() {
        return null;
    }
}
