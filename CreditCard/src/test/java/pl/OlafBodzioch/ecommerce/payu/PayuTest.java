package pl.OlafBodzioch.ecommerce.payu;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class PayuTest {

    @Test
    void creatingNewPayment(){
        PayU payu = thereIsPayU();
        OrderCreateRequest orderCreateRequest = createExampleOrderCreateRequest();

        OrderCreateResponse response = payu.handle(orderCreateRequest);

        assertNotNull(response.getRedirectUri());
        assertNotNull(response.getOrderId());
    }

    private OrderCreateRequest createExampleOrderCreateRequest() {
        var createRequest = new OrderCreateRequest();
        createRequest
                .setNotifyUrl("https://my.example.shop.ob.pl/api/order")
                .setBuyer((new Buyer())
                        .setEmail("sumio@example.com")
                        .setFirstName("Sumio")
                        .setLastName("Mondoe")
                        .setLanguage("pl")
                )
                .setExtOrderId(UUID.randomUUID().toString())
                .setTotalAmount(21000)
                .setCurrencyCode("PLN")
                .setDescription("my item")
                .setCustomerIp("192.168.11.1")
                .setMerchantPosId("300746")
                .setProducts(Arrays.asList(
                        new Product()
                                .setName("Product X")
                                .setQuantity(1)
                                .setUnitPrice(21000)
                ));

        return createRequest;
    }

    private PayU thereIsPayU() {
        return new PayU(new RestTemplate(),
                PayUCredentials.sandbox("300746", "2ee86a66e5d97e3fadc400c9f19b065d"
                        ));
    }

}
