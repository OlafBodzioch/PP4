package pl.OlafBodzioch.ecommerce.sales.reservation;

import pl.OlafBodzioch.ecommerce.sales.payment.PaymentDetails;
import pl.OlafBodzioch.ecommerce.sales.payment.PaymentGateway;
import pl.OlafBodzioch.ecommerce.sales.payment.RegisterPaymentRequest;

public class SpyPaymentGateway implements PaymentGateway {

    public int requestCount = 0;

    @Override
    public PaymentDetails registerPayment(RegisterPaymentRequest registerPaymentRequest)
    {
        this.requestCount++;
        return new PaymentDetails("http://spy-gateway");
    }

    public int getRequestCount() {
        return requestCount;
    }
}
