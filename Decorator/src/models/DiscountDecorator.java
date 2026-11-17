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
public class DiscountDecorator extends DocumentDecorator {

    private double discountRate;   // เช่น 0.10 (10%)
    private String discountReason; // เหตุผลการให้ส่วนลด

    public DiscountDecorator(SaleDocument wrappedDocument, double discountRate, String discountReason) {
        super(wrappedDocument);
        
        this.discountRate = discountRate;
        this.discountReason = discountReason;
    }

    @Override
    public double getFinalPrice() {
        double currentPrice = super.getFinalPrice();
        
        return currentPrice * (1.0 - discountRate);
    }

    @Override
    public String render() {
        double originalPrice = super.getFinalPrice();
        double discountAmount = originalPrice * discountRate;

        StringBuilder sb = new StringBuilder(super.render());
        
        sb.append(String.format(
                "ส่วนลด (%s - %.0f%%)\t: -%,.2f บาท%n",
                discountReason, 
                discountRate * 100, 
                discountAmount
        ));
        
        return sb.toString();
    }
}
