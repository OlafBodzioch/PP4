package pl.OlafBodzioch.ecommerce.sales;

public class AcceptOfferRequest {

    String firstName;
    String lastName;
    String email;

    public String getEmail()
    {
        return email;
    }

    public String firstName() {
        return firstName;
    }

    public AcceptOfferRequest setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String lastName() {
        return lastName;
    }

    public AcceptOfferRequest setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public AcceptOfferRequest setEmail(String email) {
        this.email = email;
        return this;
    }
}
