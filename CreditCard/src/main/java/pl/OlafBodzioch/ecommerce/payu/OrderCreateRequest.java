package pl.OlafBodzioch.ecommerce.payu;

import java.util.List;

public class OrderCreateRequest {

    public String notifyUrl() {
        return notifyUrl;
    }

    public OrderCreateRequest setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
        return this;
    }

    public String customerIp() {
        return customerIp;
    }

    public OrderCreateRequest setCustomerIp(String customerIp) {
        this.customerIp = customerIp;
        return this;
    }

    public String merchantPosId() {
        return merchantPosId;
    }

    public OrderCreateRequest setMerchantPosId(String merchantPosId) {
        this.merchantPosId = merchantPosId;
        return this;
    }

    public String currencyCode() {
        return currencyCode;
    }

    public OrderCreateRequest setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
        return this;
    }

    public String extOrderId() {
        return extOrderId;
    }

    public OrderCreateRequest setExtOrderId(String extOrderId) {
        this.extOrderId = extOrderId;
        return this;
    }

    public List<Product> products() {
        return products;
    }

    public OrderCreateRequest setProducts(List<Product> products) {
        this.products = products;
        return this;
    }

    public Buyer buyer() {
        return buyer;
    }

    public OrderCreateRequest setBuyer(Buyer buyer) {
        this.buyer = buyer;
        return this;
    }

    public int totalAmount() {
        return totalAmount;
    }

    public OrderCreateRequest setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    public String description() {
        return description;
    }

    public OrderCreateRequest setDescription(String description) {
        this.description = description;
        return this;
    }

    String notifyUrl;
    String customerIp;
    String merchantPosId;
    String description;
    String currencyCode;
    int totalAmount;
    String extOrderId;
    Buyer buyer;
    List<Product> products;


}
