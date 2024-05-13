package pl.OlafBodzioch.ecommerce.sales;

import java.math.BigDecimal;

public class ReservationDetails {



    public String getReservationId() {
        return "123abc";
    }


    public BigDecimal getTotal() {
        return BigDecimal.valueOf(10);
    }

    public Object getPaymentUrl() {
        return "url";
    }
}
