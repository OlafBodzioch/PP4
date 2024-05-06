package pl.OlafBodzioch.ecommerce.playground;


import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import pl.OlafBodzioch.ecommerce.catalog.Product;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class SqlTest {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @BeforeEach
    void setupDatabase() {

        jdbcTemplate.execute("DROP TABLE `productCatalog__products` IF EXISTS;");

        var createTableSql = """
                 CREATE TABLE `productCatalog__products`(
                 `id` varchar(255) NOT NULL,
                 `name` varchar(100) NOT NULL,
                 `price` decimal(12,2),
                 PRIMARY KEY(id)
                 );
                """;
        jdbcTemplate.execute(createTableSql);

    }

    @Test
    void itSelectForCurrentDate() {
        var myDate = jdbcTemplate.queryForObject("Select now() myCurrentDate", String.class);

        assertThat(myDate).contains("2024");
    }

    @Test
    void itCreatesTable() {
        jdbcTemplate.execute("DROP TABLE `productCatalog__products` IF EXISTS;");

        var createTableSql = """
                 CREATE TABLE `productCatalog__products`(
                 `id` varchar(255) NOT NULL,
                 `name` varchar(100) NOT NULL,
                 `price` decimal(12,2),
                 PRIMARY KEY(id)
                 );
                """;

        jdbcTemplate.execute(createTableSql);

        var countSql = "SELECT COUNT(*) FROM `productCatalog__products`;";
        var results = jdbcTemplate.queryForObject(countSql, Integer.class);

        assertThat(results).isEqualTo(0);

    }

    @Test
    void itStoreDynamicProducts() {
        var product = new Product(UUID.randomUUID(), "My lgeo set", "Nice one");
        product.changePrice(BigDecimal.valueOf(10.10));

        var myInsertSql = """
                    INSERT INTO `productCatalog__products` (id,name,price)
                    VALUES
                    (?, ?, ?);
                """;

        jdbcTemplate.update(myInsertSql, product.getId(), product.getName(), product.getPrice());

        var countSql = "select count(*) from `productCatalog__products`";
        var results = jdbcTemplate.queryForObject(countSql, Integer.class);



        assertThat(results).isEqualTo(1);

    }

    @Test
    void loadProductById() {
        var product = new Product(UUID.randomUUID(), "My lgeo set", "Nice one");
        product.changePrice(BigDecimal.valueOf(10.10));

        var myInsertSql = """
                INSERT INTO `productCatalog__products` (id,name,price)
                VALUES
                (?,?,?)
                ;""";

        jdbcTemplate.update(myInsertSql, product.getId(), product.getName(), product.getPrice());

        var productId = product.getId();
        var selectProductSql = "select * from `productCatalog__products` where id = ?";

        Product loadedProduct = jdbcTemplate.queryForObject(
                selectProductSql,
                new Object[]{productId},
                (rs, i) -> {
                    var myProduct = new Product(
                            UUID.fromString(rs.getString("id")),
                            rs.getString("name"),
                            rs.getString("name")
                    );
                myProduct.changePrice(BigDecimal.valueOf(rs.getDouble("price")));
                return myProduct;
                }
        );
    }

    @Test
    void itLoadsAllProductsAtOnce()
    {
        var myInsertSql = """
                    INSERT INTO `productCatalog__products` (id,name,price)
                    VALUES
                        ('product_id1','my combi set', 10.10),
                        ('product_id2','my lego set', 20.10)
                ;""";

        jdbcTemplate.execute(myInsertSql);

        List<Map<String,Object>> products = jdbcTemplate.queryForList("SELECT * FROM `productCatalog__products`");

    }

}
