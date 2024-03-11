package pl.obodzioch.creditcard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    void itDenyCreditBelowThresholdV1()
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

    @Test
    void itDenyCreditBelowThreshold() {
        var card = new CreditCard();

        assertThrows(
                CreditBelowThresholdException.class,
                () -> card.assignCredit(BigDecimal.valueOf(10))
        );
    }

    @Test
    void itDenyCreditReassignment()
        {
            CreditCard card = new CreditCard();
            card.assignCredit(BigDecimal.valueOf(1000));
            assertThrows(
                    CreditAlreadyAssignedException.class,
                    () -> card.assignCredit(BigDecimal.valueOf(1200))

            );
        }


    @Test
    void itAllowsToPayForSomething()
    {
        CreditCard card = new CreditCard();
        card.assignCredit(BigDecimal.valueOf(1000));

        card.pay(BigDecimal.valueOf(900));

        assertEquals(
                BigDecimal.valueOf(100),
                card.getBalance()
        );

    }

    @Test
    void itDenyWhenNotSufficientFounds()
    {
        CreditCard card = new CreditCard();
        card.assignCredit(BigDecimal.valueOf(1000));

        card.pay(BigDecimal.valueOf(900));

        assertThrows(
                NotEnoughMoneyException.class,
                () -> card.pay(BigDecimal.valueOf(200))
        );

        assertEquals(
                BigDecimal.valueOf(100),
                card.getBalance()
        );

    }
}