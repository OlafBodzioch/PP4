package pl.OlafBodzioch.ecommerce.catalog;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.*;


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

public class ProductCatalogTest {

    @Test
    void itListAvailableProducts()
    {
        ProductCatalog catalog = new ProductCatalog();
        new HashMap<String, String>();

        List<Product> products = catalog.allProducts();

        assert products.isEmpty();

    }

    @Test
    void itAllowsToAddProduct()
    {
        ProductCatalog catalog = new ProductCatalog();

        catalog.addProduct("Lego Set 0083","Mice");

        List<Product> products = catalog.allProducts();

        assertThat(products).hasSize(1);

    }

    @Test
    void itLoadsSingleProductById()
    {
        ProductCatalog catalog = new ProductCatalog();
        String id = catalog.addProduct("Lego Set 0083","Mice");

        Product loaded = catalog.getProductBy(id);

        assertThat(id).isEqualTo(loaded.getId());

    }

    @Test
    void itAllowsChangePrice(){

        ProductCatalog catalog = new ProductCatalog();
        String id = catalog.addProduct("Lego Set 0083","Mice");

        catalog.changePrice(id, BigDecimal.valueOf(10.10));
        Product loaded = catalog.getProductBy(id);

        assertThat(BigDecimal.valueOf(10.10)).isEqualTo(loaded.getPrice());

    }

}
