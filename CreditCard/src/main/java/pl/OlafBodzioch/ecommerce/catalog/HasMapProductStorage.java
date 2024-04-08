package pl.OlafBodzioch.ecommerce.catalog;

import java.util.HashMap;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class HasMapProductStorage implements ProductStorage{

    HashMap<String, Product> products;

    public HasMapProductStorage() {
        products = new HashMap<>();
    }

    @Override
    public List<Product> allProducts(){
        return products.values()
                .stream().toList();
    }

    @Override
    public void add(Product product){
        product.put(product.getId(), product);
    }

    @Override
    public Product getProductBy(String id){
        return  products.get(id);
    }

}
