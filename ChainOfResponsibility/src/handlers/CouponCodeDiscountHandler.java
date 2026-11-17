/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package handlers;

import java.util.Map;
import models.Order;

/**
 *
 * @author macbook
 */
public class CouponCodeDiscountHandler extends BaseHandler {

    private Map<String, Double> validCodes;

    public CouponCodeDiscountHandler(Map validCodes) {
        this.validCodes = validCodes;
    }

    @Override
    public void handle(Order order) {
        if (validCodes.containsKey(order.getCouponCode())) {
            double discount = Math.min(validCodes.get(order.getCouponCode()), order.getCurrentAmount());
            order.applyDiscount(discount);
            
            System.out.printf("- [CouponCode] ใช้คูปอง '%s' สำเร็จ (-%,.2f บาท)%n", order.getCouponCode(), discount);
        }

        super.handle(order);
    }
}
