package pl.OlafBodzioch.ecommerce;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.OlafBodzioch.ecommerce.catalog.ProductCatalog;
import pl.OlafBodzioch.ecommerce.infastructure.PayUPaymentGw;
import pl.OlafBodzioch.ecommerce.sales.SalesFacade;
import pl.OlafBodzioch.ecommerce.sales.offering.OfferCalculator;
import pl.OlafBodzioch.ecommerce.sales.reservation.ReservationRepository;

@SpringBootApplication

public class App {

    public static void main(String[] args)
    {
        SpringApplication.run(App.class, args);
    }

    @Bean
    ProductCatalog createMyProductCatalog()
    {
        var catalog = new ProductCatalog();
        catalog.addProduct("Lego set 0083","Mice one");
        catalog.addProduct("Cobi blocks","Mice one");

        return  catalog;
    }

    @Bean
    SalesFacade CreateSales()
    {
        return new SalesFacade(
                new CartStorage(),
                new OfferCalculator(),
                new PayUPaymentGw(),
                new ReservationRepository()
        );
    }

}
