package pl.OlafBodzioch.ecommerce.sales;

public class AcceptOfferRequest {

    String firstname;
    String lastname;
    String email;

    public String getLastname() {
        return lastname;
    }

    public pl.OlafBodzioch.ecommerce.sales.reservation.AcceptOfferRequest setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public pl.OlafBodzioch.ecommerce.sales.reservation.AcceptOfferRequest setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getFirstname() {
        return firstname;
    }

    public pl.OlafBodzioch.ecommerce.sales.reservation.AcceptOfferRequest setFirstname() {
        return setFirstname(null);
    }

    public pl.OlafBodzioch.ecommerce.sales.reservation.AcceptOfferRequest setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }
}
