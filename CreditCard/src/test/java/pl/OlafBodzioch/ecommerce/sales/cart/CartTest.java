package pl.OlafBodzioch.ecommerce.sales.cart;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


public class CartTest {

    @Test
    void itIsEmptyWhenCreated()
    {
        Cart cart = Cart.empty();

        assertThat(cart.isEmpty())
                .isTrue();
    }

    @Test
    void itIsNotEmptyWhenProductWasAdded()
    {
        Cart cart = Cart.empty();
        String productId = thereIsProduct("X");

        cart.addProduct(productId);

        assertThat(cart.isEmpty())
                .isFalse();
    }

    @Test
    void itExposeUniqueProductCountS1(){
            Cart cart = Cart.empty();
            String productX = thereIsProduct("X");

            cart.addProduct(productX);

            assertThat(cart.getLinesCount())
                    .isEqualTo(1);
    }

    @Test
    void itExposeUniqueProductCountS2(){
        Cart cart = Cart.empty();
        String productX = thereIsProduct("X");

        cart.addProduct(productX);
        cart.addProduct(productX);

        assertThat(cart.getLinesCount())
                .isEqualTo(1);
    }

    @Test
    void itExposeUniqueProductCountS3(){
        Cart cart = Cart.empty();
        String productX = thereIsProduct("X");
        String productY = thereIsProduct("Y");

        cart.addProduct(productX);
        cart.addProduct(productX);
        cart.addProduct(productY);

        assertThat(cart.getLinesCount())
                .isEqualTo(2);
    }

    private String thereIsProduct(String id) {
        return id;
    }

    @Test
    void itExposeCartLineQuantityS1(){
        Cart cart = Cart.empty();
        String productX = thereIsProduct("X");

        cart.addProduct(productX);

        List<CartLine> lines = cart.getLines();

        assertCartContainsXAmountOfProduct(lines, productX, 1);
    }

    @Test
    void itExposeCartLineQuantityS2(){
        Cart cart = Cart.empty();
        String productX = thereIsProduct("X");

        cart.addProduct(productX);
        cart.addProduct(productX);

        List<CartLine> lines = cart.getLines();

        assertCartContainsXAmountOfProduct(lines, productX, 2);
    }

    @Test
    void itExposeCartLineQuantityS3(){
        Cart cart = Cart.empty();
        String productX = thereIsProduct("X");
        String productY = thereIsProduct("Y");

        cart.addProduct(productX);
        cart.addProduct(productY);
        cart.addProduct(productX);
        cart.addProduct(productY);

        List<CartLine> lines = cart.getLines();

        assertCartContainsXAmountOfProduct(lines, productX, 2);
        assertCartContainsXAmountOfProduct(lines, productY, 2);
    }

    private void assertCartContainsXAmountOfProduct(List<CartLine> lines, String productId, int count)
    {
        assertThat(lines)
                .filteredOn(cartLine -> cartLine.getProductId().equals(productId))
                .extracting(cartLine -> cartLine.getQty())
                .first()
                .isEqualTo(count);
    }
}
