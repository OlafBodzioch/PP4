package pl.OlafBodzioch.ecommerce.sales.payment;

public abstract interface PaymentGateway {

    public abstract PaymentDetails registerPayment(RegisterPaymentRequest registerPaymentRequest);
}
