package pl.OlafBodzioch.ecommerce.sales.reservation;

import org.junit.jupiter.api.Test;
import pl.OlafBodzioch.ecommerce.sales.AcceptOfferRequest;
import pl.OlafBodzioch.ecommerce.sales.SalesFacade;
import pl.OlafBodzioch.ecommerce.sales.offering.OfferCalculator;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

public class OfferAcceptanceTest {

    private SpyPaymentGateway spyPaymentGateway;
    private ReservationRepository reservationRepository;

    @Test
    void itAllowsToAcceptAnOffer()
    {

        SalesFacade sales = thereIsSales();
        String customerId = thereIsCustomer("sumio");
        String productId = thereIsProduct("X", BigDecimal.valueOf(10));

        sales.addToCart(customerId, productId);
        sales.addToCart(customerId, productId);

        var acceptOfferRequest = new AcceptOfferRequest();
        acceptOfferRequest
                .setFirstName("john")
                .setLastName("doe")
                .setEmail("john.doe@example.com");

        ReservationDetails reservationDetails = sales.acceptOffer(customerId, acceptOfferRequest);

        assertThat(reservationDetails.getReservationId()).isNotBlank();
        assertThat(reservationDetails.getPaymentUrl()).isNotBlank();

        assertPaymentHasBeenRegistered();
        assertThereIsReservationWithId(reservationDetails.getReservationId());
        assertReservationIsPending(reservationDetails.getReservationId());
        assertReservationIsDoneForCustomer(reservationDetails.getReservationId(), "john", "doe", "john.doe@example.com");
        assertReservationTotalMatchOffer(reservationDetails.getReservationId(), BigDecimal.valueOf(20));

    }

    private void assertReservationTotalMatchOffer(String reservationId, BigDecimal expectedTotal)
    {
        Reservation loaded = reservationRepository.load(reservationId)
                .get();

        assertThat(loaded.getTotal()).isEqualTo(expectedTotal);
    }

    private void assertReservationIsDoneForCustomer(String reservationId, String firstName, String lastName, String email)
    {

        Reservation loaded = reservationRepository.load(reservationId)
                .get();

        CustomerDetails clientData = loaded.getCustomerDetail();

        assertThat(clientData.getFirstName()).isEqualTo(firstName);
        assertThat(clientData.getLastName()).isEqualTo(lastName);
        assertThat(clientData.getEmail()).isEqualTo(email);
    }

    private void assertReservationIsPending(String reservationId)
    {

        Reservation loaded = reservationRepository.load(reservationId)
                .get();

        assertThat(loaded.isPending()).isTrue();

    }

    private void assertThereIsReservationWithId(String reservationId)
    {

        Optional<Reservation> loaded = reservationRepository.load(reservationId);

        assertThat(loaded).isPresent();
    }

    private void assertPaymentHasBeenRegistered() {

        assertThat(spyPaymentGateway.getRequestsCount()).isEqualTo(1);

    }

    private String thereIsProduct(String productId, BigDecimal price)
    {
        return productId;
    }

    private String thereIsCustomer(String id)
    {
        return id;
    }

    private SalesFacade thereIsSales()
    {
        return new SalesFacade(
                new CartStorage(),
                new OfferCalculator(),
                new SpyPaymentGateway(),
                new ReservationRepository()
        );
    }


}