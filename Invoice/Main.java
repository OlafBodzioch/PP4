import java.util.ArrayList;

public class Main {
    public static void main(String[] args) 
    {
    
    Invoice inv1 = new Invoice("Clean Code", "Robert C. Martin", 100.00, 0.08);
    Invoice inv2 = new Invoice("Applying UML and Patterns", "C. Larman", 300.00, 0.08);
    Invoice inv3 = new Invoice("Shipping", null, 50.00, 0.23);

    ArrayList<Invoice> InvoiceSet = new ArrayList<Invoice>();

    InvoiceSet.add(inv1);
    InvoiceSet.add(inv2);
    InvoiceSet.add(inv3);

    //vat8 netto value
    double sum8 = 0;

        for(Invoice Invoice : InvoiceSet) 
        {
            if(Invoice.getVatValue() == 0.08)
                sum8 = sum8 + Invoice.getNettoValue();
        }

    //vat23 netto value
    double sum23 = 0;

    for(Invoice Invoice : InvoiceSet) 
    {
        if(Invoice.getVatValue() == 0.23)
            sum23 = sum23 + Invoice.getNettoValue();
    }


    System.out.printf("| %13s | %3s %-9s | %3s %-9s |%n", "","",sum23+sum8,"",sum23*0.23 + sum8*0.08);


    System.out.printf("|%-13s|%-13s|%-13s|%n", "---------------","---------------","---------------");

    System.out.printf("| %-13s | %3s %-9s | %3s %-9s |%n", "VAT 8%","",sum8,"",sum8*0.08);

    System.out.printf("| %-13s | %3s %-9s | %3s %-9s |%n", "VAT 23%","",sum23,"",sum23*0.23);

    }
}
