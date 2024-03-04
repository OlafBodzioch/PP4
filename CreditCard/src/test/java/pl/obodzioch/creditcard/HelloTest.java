package pl.obodzioch.creditcard;

import org.junit.jupiter.api.Test;

public class HelloTest {
    @Test
    void helloTest()
    {
        var name = "bebek";
        var message = String.format("Hello %s",name);
        System.out.println(message);
    }

    @Test
    void equationTest()
    {
        //A / Arrange
        int a = 2;
        int b = 3;
        //A / Act
        var result = a + b;
        //A / Asset
        assert(5==result);
    }
}
