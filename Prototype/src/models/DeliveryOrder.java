/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author macbook
 */
public class DeliveryOrder extends SaleDocument {

    private String shippingAddress;
    private String deliveryDate;
    private String carrierName;
    private String receiverName;
    private String trackingNumber;

    public DeliveryOrder(SaleDocument target) {
        super(target);
        
        if (target instanceof DeliveryOrder doDoc) {
            this.shippingAddress = doDoc.shippingAddress;
            this.deliveryDate = doDoc.deliveryDate;
            this.carrierName = doDoc.carrierName;
        }
    }

    @Override
    public SaleDocument copy() {
        return new DeliveryOrder(this);
    }

    public void deductStock() {
        System.out.println(">>> Biz Logic: Stock deducted from system for DO: " + docNo);
    }

    public void setShipping(String addr, String date) {
        this.shippingAddress = addr;
        this.deliveryDate = date;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        
        System.out.println("Ship to: " + shippingAddress + " | Date: " + deliveryDate);
    }
}
