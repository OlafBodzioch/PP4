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

    //lengths of each value
    int nettoSumLen = Double.toString(sum23+sum8).length();
    int vat8NettoValueSumLen = Double.toString(sum8).length();
    int vat23NettoValueSumLen = Double.toString(sum23).length();
    int vat8ValueSumLen = Double.toString(sum8*0.08).length();
    int vat23ValueSumLen = Double.toString(sum23*0.23).length();
    int vatFullValueSumLen = Double.toString(sum23*0.23+sum8*0.08).length();


    //first row - sum of netto and sum of netto*vat
 
    System.out.print("|");

    for (int i = 0; i < 15; i++) 
    {
        System.out.print(" ");
    }

    System.out.print("|");

    for (int i = 0; i < 15; i++) 
    {
        if (i==(15/2)-nettoSumLen/2) 
        {
            System.out.print(sum23+sum8);
            i = i + nettoSumLen - 1;    
        }
        else
            System.out.print(" ");
    }

    //second row

    System.out.print("|");

    for (int i = 0; i < 15; i++) 
    {
        if (i==(15/2)-vatFullValueSumLen/2) 
        {
            System.out.print(sum23*0.23+sum8*0.08);
            i = i + nettoSumLen - 2;    
        }
        else
            System.out.print(" ");
    }

    System.out.print("|\n");

    System.out.print("|---------------|---------------|---------------|\n");

    //third row = netto 8% and netto 8% * vat

    System.out.print("|VAT 8%         |");


    for (int i = 0; i < 15; i++) 
    {
        if (i==(15/2)-vat8NettoValueSumLen/2) 
        {
            System.out.print(sum8);
            i = i + nettoSumLen - 1;    
        }
        else
            System.out.print(" ");
    }

    System.out.print("|");

    for (int i = 0; i < 15; i++) 
    {
        if (i==(15/2)-vat8ValueSumLen/2) 
        {
            System.out.print(sum8*0.08);
            i = i + nettoSumLen - 2;    
        }
        else
            System.out.print(" ");
    }

    System.out.print("|\n");

    //fourth row - netto of vat23% and netto*vat 23%

    System.out.print("|VAT 23%        |");


    for (int i = 0; i < 15; i++) 
    {
        if (i==(15/2)-vat23NettoValueSumLen/2) 
        {
            System.out.print(sum23);
            i = i + nettoSumLen - 2;    
        }
        else
            System.out.print(" ");
    }

    System.out.print("|");

    for (int i = 0; i < 15; i++) 
    {
        if (i==(15/2)-vat23ValueSumLen/2) 
        {
            System.out.print(sum23*0.23);
            i = i + nettoSumLen - 2;    
        }
        else
            System.out.print(" ");
    }

    System.out.print("|\n");

    }
}
