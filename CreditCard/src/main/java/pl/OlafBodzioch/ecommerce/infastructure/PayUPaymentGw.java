package pl.OlafBodzioch.ecommerce.infastructure;

import pl.OlafBodzioch.ecommerce.sales.payment.PaymentDetails;
import pl.OlafBodzioch.ecommerce.sales.payment.PaymentGateway;
import pl.OlafBodzioch.ecommerce.sales.payment.RegisterPaymentRequest;

public class PayUPaymentGw implements PaymentGateway {

    @Override
    public PaymentDetails registerPayment(RegisterPaymentRequest registerPaymentRequest)
    {

        return null;

    }



}
