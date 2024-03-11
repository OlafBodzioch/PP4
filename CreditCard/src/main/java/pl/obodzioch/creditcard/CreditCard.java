package pl.obodzioch.creditcard;

import java.math.BigDecimal;

public class CreditCard {

    private BigDecimal creditLimit;

    public void assignCredit(BigDecimal creditLimit) {

        if (isCreditAlreadyAssigned()) {
            throw new CreditAlreadyAssignedException();
        }

        if (isCreditBelowThreshold(creditLimit)) {
            throw new CreditBelowThresholdException();
        }

        this.creditLimit = creditLimit;
    }

    private boolean isCreditBelowThreshold(BigDecimal creditLimit) {
        return BigDecimal.valueOf(100).compareTo(creditLimit) > 0;
    }

    private boolean isCreditAlreadyAssigned() {
        return this.creditLimit != null;
    }

    public BigDecimal getBalance()
    {
        return creditLimit;
    }

}
