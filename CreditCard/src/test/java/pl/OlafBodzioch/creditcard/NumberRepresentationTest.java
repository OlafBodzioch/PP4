package pl.OlafBodzioch.creditcard;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class NumberRepresentationTest {

    @Test
    void doubleTest()
    {
        double a = 0.02;
        double b = 0.03;
        System.out.println("Double");
        System.out.println(a-b);
    }

    @Test
    void floatTest()
    {
        float a = 0.02f;
        float b = 0.03f;
        System.out.println("Float");
        System.out.println(a-b);
    }

    @Test
    void bigDecimalTest()
    {
        BigDecimal a = new BigDecimal("0.02");
        BigDecimal b = new BigDecimal("0.03");
        System.out.println("Big Decimal");
        System.out.println(a.subtract(b));
    }

}
