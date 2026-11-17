/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author macbook
 */
public class Quotation extends SaleDocument {

    private String dueDate;
    private String salesPerson;
    private String paymentTerms;
    private double discountRate;
    private int version;

    public Quotation() {
    }

    public Quotation(SaleDocument target) {
        super(target);

        if (target instanceof Quotation qt) {
            this.dueDate = qt.dueDate;
            this.salesPerson = qt.salesPerson;
            this.paymentTerms = qt.paymentTerms;
            this.discountRate = qt.discountRate;
            this.version = qt.version;
        }
    }

    @Override
    public SaleDocument copy() {
        return new Quotation(this);
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getSalesPerson() {
        return salesPerson;
    }

    public void setSalesPerson(String salesPerson) {
        this.salesPerson = salesPerson;
    }

    public String getPaymentTerms() {
        return paymentTerms;
    }

    public void setPaymentTerms(String paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public double calculateAmoutWithDiscount() {
        return calculateTotalAmount() * (0.01 * (100 - getDiscountRate()));
    }

    @Override
    public void showInfo() {
        super.showInfo();

        System.out.println(
                "PaymentTerm: " + paymentTerms
                + " | Due: " + dueDate
                + " | Discount: " + discountRate + "% "
                + " | Ver: " + version);
    }
}
