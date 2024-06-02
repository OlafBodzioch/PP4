package pl.OlafBodzioch.ecommerce.sales.reservation;

import java.math.BigDecimal;

public class ReservationDetails {

    private final String reservationId;
    private final String paymentUrl;

    public String getReservationId(){
        return reservationId;
    }

    public String getPaymentUrl(){
        return paymentUrl;
    }

    public ReservationDetails(String reservationId, String paymentUrl) {
        this.reservationId = reservationId;
        this.paymentUrl = paymentUrl;
    }
}
