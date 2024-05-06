package pl.OlafBodzioch.ecommerce.catalog;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProductCatalog {

    private ArrayListProductStorage productStorage;

    public ProductCatalog()
    {

        this.productStorage = new ArrayListProductStorage();

    }

    public List<Product> allProducts()
    {

        return productStorage.allProducts();

    }

    public String addProduct(String name, String description)
    {
        UUID id = UUID.randomUUID();
        Product newProduct = new Product(id, name, description);


        productStorage.add(newProduct);
        return newProduct.getId();
    }

    public void changePrice(String id, BigDecimal newPrice) {

        Product loaded = this.getProductBy(id);
        loaded.changePrice(newPrice);

    }

    public Product getProductBy(String id) {

        return productStorage.getProductBy(id);

    }

}
