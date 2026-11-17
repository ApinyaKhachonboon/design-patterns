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
public class MemberTierDiscountHandler extends BaseHandler {

    @Override
    public void handle(Order order) {
        double rate = 0.0;
        
        if ("GOLD".equalsIgnoreCase(order.getMemberTier())) {
            rate = 0.05; // Gold ลด 5%
        } else if ("PLATINUM".equalsIgnoreCase(order.getMemberTier())) {
            rate = 0.10; // Platinum ลด 10%
        }

        if (rate > 0) {
            double discount = order.getCurrentAmount() * rate;
            order.applyDiscount(discount);
            
            System.out.printf(
                    "- [MemberTier] ระดับ %s ลดทันที %.0f%% (-%,.2f บาท)%n",
                    order.getMemberTier(), 
                    rate * 100, 
                    discount
            );
        }

        super.handle(order);
    }
}
