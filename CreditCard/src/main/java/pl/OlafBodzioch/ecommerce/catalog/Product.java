package pl.OlafBodzioch.ecommerce.catalog;

import java.math.BigDecimal;
import java.util.UUID;

public class Product {
    private final String id;
    private final String name;

    private BigDecimal price;

    private final String description;



    public Product(UUID id, String name, String description) {
        this.id = id.toString();
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal changePrice(BigDecimal price) {

        return price;
    }

    public String getName() {
        return name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }
}
