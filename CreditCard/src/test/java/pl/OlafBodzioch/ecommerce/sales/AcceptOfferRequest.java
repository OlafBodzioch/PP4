package pl.OlafBodzioch.ecommerce.sales;

public class AcceptOfferRequest {

    String firstname;
    String lastname;
    String email;

    public String getLastname() {
        return lastname;
    }

    public AcceptOfferRequest setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public AcceptOfferRequest setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getFirstname() {
        return firstname;
    }

    public AcceptOfferRequest setFirstname() {
        return setFirstname(null);
    }

    public AcceptOfferRequest setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }
}
