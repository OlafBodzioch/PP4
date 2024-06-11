package pl.OlafBodzioch.ecommerce.payu;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class PayU {

    RestTemplate http;
    private final PayUCredentials payUCredentials;

    public PayU(RestTemplate http, PayUCredentials payUCredentials)
    {
        this.payUCredentials = payUCredentials;
        this.http = http;
    }

    public OrderCreateResponse handle(OrderCreateRequest orderCreateRequest) {

        //Authorize
        HttpHeaders headers = new HttpHeaders();

        headers.add("Content-Type", "application/json");
        headers.add("Authorization", String.format("Bearer %s", getToken()));

        HttpEntity<OrderCreateRequest> request = new HttpEntity<>(orderCreateRequest, headers);

        ResponseEntity<OrderCreateResponse> orderCreateResponseResponse = http.postForEntity(
                String.format("%s/api/v2_1/orders", payUCredentials.getBaseUrl()),
                request,
                OrderCreateResponse.class
        );

        //Create order
        return orderCreateResponseResponse.getBody();

    }

    private String getToken() {

        String body = String.format("grant-type=client_credentials&client_id=%s&client_secret=%s",
                payUCredentials.getClientId(),
                payUCredentials.getClientSecret()
        );

        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<String> request = new HttpEntity<>(body, headers);

        ResponseEntity<AccessTokenResponse> atResponseResponse = http.postForEntity(
                String.format("%s/pl/standard/user/oauth/authorize", payUCredentials.getBaseUrl()),
                request,
                AccessTokenResponse.class
        );

        return atResponseResponse.getBody().getAccessToken();
    }
}
