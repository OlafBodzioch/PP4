package pl.OlafBodzioch.creditcard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class AssertjTest {

    @Test
    void HelloAssertJ()
    {
        var hello = "Hello world";

        assertThat(hello).containsOnlyDigits();

        assertThat(hello).hasSize(11);
    }

}
