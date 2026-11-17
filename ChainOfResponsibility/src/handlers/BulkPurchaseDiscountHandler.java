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
public class BulkPurchaseDiscountHandler extends BaseHandler {

    private int minItemCount;
    private double discountRate;

    public BulkPurchaseDiscountHandler(int minItemCount, double discountRate) {
        this.minItemCount = minItemCount;
        this.discountRate = discountRate;
    }

    @Override
    public void handle(Order order) {
        if (order.getTotalItems() >= minItemCount) {
            double discount = order.getCurrentAmount() * discountRate;
            order.applyDiscount(discount);
            
            System.out.printf(
                    "- [BulkPurchase] ซื้อครบ %d ชิ้น (สั่งซื้อ %d ชิ้น) ลดเพิ่ม %.0f%% (-%,.2f บาท)%n",
                    minItemCount, 
                    order.getTotalItems(), 
                    discountRate * 100, 
                    discount
            );
        }

        super.handle(order);
    }
}
