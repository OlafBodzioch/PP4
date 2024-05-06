import java.util.ArrayList;

public class Invoice {
    
    private String item;
    private String author;
    private double nettoValue;
    private double vatValue;

    public String getItem() {
        return item;
    }
    public void setItem(String item) {
        this.item = item;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public double getNettoValue() {
        return nettoValue;
    }
    public void setNettoValue(double nettoValue) {
        this.nettoValue = nettoValue;
    }
    public double getVatValue() {
        return vatValue;
    }
    public void setVatValue(double vatValue) {
        this.vatValue = vatValue;
    }
    
    public Invoice(String item, String author, double nettoValue, double vatValue) {
        this.item = item;
        this.author = author;
        this.nettoValue = nettoValue;
        this.vatValue = vatValue;
    }

}