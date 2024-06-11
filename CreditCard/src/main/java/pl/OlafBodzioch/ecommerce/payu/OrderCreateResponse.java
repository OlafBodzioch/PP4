package pl.OlafBodzioch.ecommerce.payu;

public class OrderCreateResponse {


    Status status;
    String redirectUri;
    String orderId;
    String extOrderId;

    public String getRedirectUri() {
        return redirectUri;
    }

    public String getOrderId() {
        return orderId;
    }

    public Status status() {
        return status;
    }

    public OrderCreateResponse setStatus(Status status) {
        this.status = status;
        return this;
    }

    public String orderId() {
        return orderId;
    }

    public OrderCreateResponse setOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public String redirectUri() {
        return redirectUri;
    }

    public OrderCreateResponse setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
        return this;
    }

    public String extOrderId() {
        return extOrderId;
    }

    public OrderCreateResponse setExtOrderId(String extOrderId) {
        this.extOrderId = extOrderId;
        return this;
    }
}
