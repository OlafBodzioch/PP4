package pl.OlafBodzioch.ecommerce.payu;

public class Status {

    String statusCode;

    public String statusCode() {
        return statusCode;
    }

    public Status setStatusCode(String statusCode) {
        this.statusCode = statusCode;
        return this;
    }
}
