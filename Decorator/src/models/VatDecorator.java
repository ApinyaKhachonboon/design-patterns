/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import interfaces.SaleDocument;

/**
 *
 * @author macbook
 */

public class VatDecorator extends DocumentDecorator {
    private double vatRate;
    private String taxRegistrationNo;
    private boolean isInclusive;
    private String branchCode;

    public VatDecorator(
            SaleDocument wrappedDocument, 
            double vatRate, 
            String taxRegistrationNo, 
            boolean isInclusive, 
            String branchCode
    ) {
        super(wrappedDocument);
        
        this.vatRate = vatRate;
        this.taxRegistrationNo = taxRegistrationNo;
        this.isInclusive = isInclusive;
        this.branchCode = branchCode;
    }

    @Override
    public double getFinalPrice() {
        double currentPrice = super.getFinalPrice();
        
        if (isInclusive) {
            return currentPrice;
        } else {
            return currentPrice * (1.0 + vatRate);
        }
    }

    @Override
    public String render() {
        double basePrice = super.getFinalPrice();
        
        double vatAmount = isInclusive 
                ? basePrice * (vatRate / (1.0 + vatRate)) 
                : basePrice * vatRate;

        StringBuilder sb = new StringBuilder(super.render());
        
        sb.append("-----------------------------------------------------------------\n");
        sb.append(String.format("เลขผู้เสียภาษีผู้ขาย (Tax ID)\t: %s (สาขา: %s)\n", taxRegistrationNo, branchCode));
        
        if (isInclusive) {
            sb.append(String.format("ภาษีมูลค่าเพิ่ม (VAT %.0f%% ในราคา)\t:  %,.2f บาท\n", vatRate * 100, vatAmount));
        } else {
            sb.append(String.format("ภาษีมูลค่าเพิ่ม (VAT %.0f%% บวกเพิ่ม)\t: +%,.2f บาท\n", vatRate * 100, vatAmount));
        }
        
        return sb.toString();
    }
}
