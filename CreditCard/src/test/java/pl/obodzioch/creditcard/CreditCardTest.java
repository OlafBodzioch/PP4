package pl.obodzioch.creditcard;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class CreditCardTest
{

    @Test
    void itAssignCredit()
    {
        //ARRANGE
        var card = new CreditCard();
        //ACT
        card.assignCredit(BigDecimal.valueOf(1000));
        //ASSERT
        assert BigDecimal.valueOf(1000).equals(card.getBalance());
    }

    @Test
    void itAssignCreditV2()
    {
        //ARRANGE
        var card = new CreditCard();
        //ACT
        card.assignCredit(BigDecimal.valueOf(1500));
        //ASSERT
        assert BigDecimal.valueOf(1500).equals(card.getBalance());
    }

    @Test
    void itDenyCreditBelowThreshold()
    {
        var card = new CreditCard();

        try{
            card.assignCredit(BigDecimal.valueOf(50));
            assert false;
        }
        catch(CreditBelowThresholdException e)
        {
            assert  true;
        }

    }

}
