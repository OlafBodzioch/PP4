package pl.OlafBodzioch.ecommerce.payu;

public class Buyer {

    public String email() {
        return email;
    }

    public Buyer setEmail(String email) {
        this.email = email;
        return this;
    }

    public String phone() {
        return phone;
    }

    public Buyer setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String firstName() {
        return firstName;
    }

    public Buyer setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String lastName() {
        return lastName;
    }

    public Buyer setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String language() {
        return language;
    }

    public Buyer setLanguage(String language) {
        this.language = language;
        return this;
    }

    String email;
    String phone;
    String firstName;
    String lastName;
    String language;

}
