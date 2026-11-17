/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package handlers;

import models.Order;

/**
 *
 * @author macbook
 */
public class FreeShippingHandler extends BaseHandler {
    private double minSpendForFree;

    public FreeShippingHandler(double minSpendForFree) {
        this.minSpendForFree = minSpendForFree;
    }

    @Override
    public void handle(Order order) {
        if (order.getCurrentAmount() >= minSpendForFree) {
            order.setShippingFee(0.0);
            
            System.out.printf("- [FreeShipping] ยอดสุทธิหลังหักส่วนลดเกิน %,.2f บาท -> ส่งฟรี!%n", minSpendForFree);
        } else {
            System.out.printf(
                    "- [FreeShipping] ยอดสุทธิหลังหักส่วนลดไม่ถึง %,.2f บาท -> ค่าส่ง %,.2f บาท%n",
                    minSpendForFree, 
                    order.getShippingFee()
            );
        }

        super.handle(order);
    }
}
