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

public class UrgentDecorator extends DocumentDecorator {
    private double surchargeFee;         // ค่าธรรมเนียมจัดส่งด่วนพิเศษ
    private int guaranteedDeliveryDays; // การรับประกันส่งภายใน X วัน

    public UrgentDecorator(SaleDocument wrappedDocument, double surchargeFee, int guaranteedDeliveryDays) {
        super(wrappedDocument);
        
        this.surchargeFee = surchargeFee;
        this.guaranteedDeliveryDays = guaranteedDeliveryDays;
    }

    @Override
    public double getFinalPrice() {
        return super.getFinalPrice() + surchargeFee;
    }

    @Override
    public String render() {
        StringBuilder sb = new StringBuilder();
        
        sb.append(">>> [URGENT EXTREME - ด่วนที่สุด ภายใน ").append(guaranteedDeliveryDays).append(" วัน] <<<\n");
        sb.append(super.render());
        sb.append(String.format("ค่าธรรมเนียมจัดส่งด่วน\t: +%,.2f บาท%n", surchargeFee));
        
        return sb.toString();
    }
}
