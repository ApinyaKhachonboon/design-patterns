/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author macbook
 */
public class Order {

    private String orderId;
    private String memberTier; // "REGULAR", "GOLD", "PLATINUM"
    private String couponCode;
    private int totalItems;
    private double subtotal;

    private double totalDiscount = 0.0;
    private double shippingFee = 50.0; // ค่าส่งเริ่มต้น 50 บาท

    public Order(String orderId, String memberTier, String couponCode, int totalItems, double subtotal) {
        this.orderId = orderId;
        this.memberTier = memberTier;
        this.couponCode = couponCode;
        this.totalItems = totalItems;
        this.subtotal = subtotal;
    }

    public void applyDiscount(double amount) {
        this.totalDiscount += amount;
    }

    public double getCurrentAmount() {
        return Math.max(0.0, subtotal - totalDiscount);
    }

    public double getNetTotal() {
        return getCurrentAmount() + shippingFee;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getMemberTier() {
        return memberTier;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getTotalDiscount() {
        return totalDiscount;
    }

    public double getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(double shippingFee) {
        this.shippingFee = shippingFee;
    }
}
