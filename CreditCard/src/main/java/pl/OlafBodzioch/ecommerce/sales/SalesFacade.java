package pl.OlafBodzioch.ecommerce.sales;

import pl.OlafBodzioch.ecommerce.sales.cart.Cart;
import pl.OlafBodzioch.ecommerce.sales.cart.InMemoryCartStorage;
import pl.OlafBodzioch.ecommerce.sales.offering.Offer;
import pl.OlafBodzioch.ecommerce.sales.offering.OfferCalculator;
import pl.OlafBodzioch.ecommerce.sales.payment.PaymentDetails;
import pl.OlafBodzioch.ecommerce.sales.payment.PaymentGateway;
import pl.OlafBodzioch.ecommerce.sales.payment.RegisterPaymentRequest;
import pl.OlafBodzioch.ecommerce.sales.reservation.Reservation;
import pl.OlafBodzioch.ecommerce.sales.reservation.ReservationDetails;
import pl.OlafBodzioch.ecommerce.sales.reservation.ReservationRepository;

import java.util.UUID;

public class SalesFacade {

    private InMemoryCartStorage cartStorage;
    private OfferCalculator offerCalculator;
    private PaymentGateway paymentGateway;
    private ReservationRepository reservationRepository;

    public SalesFacade(InMemoryCartStorage cartStorage, OfferCalculator offerCalculator, PaymentGateway paymentGateway, ReservationRepository reservationRepository) {
        this.cartStorage = cartStorage;
        this.offerCalculator = offerCalculator;
        this.paymentGateway = paymentGateway;
        this.reservationRepository = reservationRepository;
    }

    public void addToCart(String customerId, String productId){
        Cart cart = loadCartForCustomer(customerId);
        cart.addProduct(productId);
    }

    private Cart loadCartForCustomer(String customerId){
        return cartStorage.findByCustomerId(customerId).
                orElse(Cart.empty());
    }

    public Offer getCurrentOffer(String customerId) {

        return  new Offer();

    }

    public ReservationDetails acceptOffer(String customerId, AcceptOfferRequest acceptOfferRequest){

        String reservationId = UUID.randomUUID().toString();

        Offer offer = this.getCurrentOffer(customerId);

        PaymentDetails paymentDetails = paymentGateway.registerPayment(
            RegisterPaymentRequest.of(acceptOfferRequest, offer.getTotal())
        );

        Reservation reservation = Reservation.of(reservationId, customerId, acceptOfferRequest, paymentDetails);

        reservationRepository.add(reservation);

        return new ReservationDetails(reservationId, paymentDetails.getPaymentUrl());

    }



}
