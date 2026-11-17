/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author macbook
 */
public class Invoice extends SaleDocument {

    private String taxId;
    private double vatAmount;
    private double netAmount;

    public Invoice(SaleDocument target) {
        super(target);
        
        if (target instanceof Invoice iv) {
            this.taxId = iv.taxId;
            this.vatAmount = iv.vatAmount;
            this.netAmount = iv.netAmount;
        }
    }

    @Override
    public SaleDocument copy() {
        return new Invoice(this);
    }

    public void postToAccount() {
        System.out.println(">>> Biz Logic: Posted to General Ledger (ส่งไปทำรายรับ-รายจ่าย).");
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public double getVatAmount() {
        return vatAmount;
    }

    public void setVatAmount(double vatAmount) {
        this.vatAmount = vatAmount;
    }

    public double getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(double netAmount) {
        this.netAmount = netAmount;
    }
    
    public double calculateVat() {
        return getTotalAmount() * 0.07;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        
        System.out.println("Tax ID: " + taxId + " | VAT: " + String.format("%.2f", vatAmount) + " | Net: " + netAmount);
    }
}
