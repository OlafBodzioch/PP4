package pl.OlafBodzioch.ecommerce.catalog;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class HasMapProductStorageTest {

    public static final String TEST_PRODUCT_NAME = "test product";

    @Test
    void itStoreNewProduct(){

        //arrange
        ProductStorage storage = thereIsProductStorage();
        Product product = thereIsExampleProduct();
        //act
        storage.add(product);
        //assert
        List<Product> products = storage.allProducts();
        assertThat(products)
                .hasSize(1)
                .extracting(Product::getName)
                .contains(TEST_PRODUCT_NAME);

    }

    private Product thereIsProductStorage() {
        return new HasMapProductStorage();
    }

    private Product thereIsExampleProduct() {
        return new Product(UUID.randomUUID());
    }



}
