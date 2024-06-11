package pl.OlafBodzioch.ecommerce.payu;

public class Product {

    public String name() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public int unitPrice() {
        return unitPrice;
    }

    public Product setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
        return this;
    }

    public int quantity() {
        return quantity;
    }

    public Product setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    String name;
    int unitPrice;
    int quantity;

}
