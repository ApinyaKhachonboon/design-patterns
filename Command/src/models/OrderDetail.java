/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author macbook
 */
public class OrderDetail {

    private MenuItem item;
    private int quantity;
    private String status; // "PENDING", "COOKING", "SERVED", "CANCELLED"

    public OrderDetail(MenuItem item, int quantity) {
        this.item = item;
        this.quantity = quantity;
        this.status = "PENDING";
    }

    public MenuItem getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getSubtotal() {
        return item.getPrice() * quantity;
    }

    public void cancel() {
        this.status = "CANCELLED";
    }

    public boolean isCancelled() {
        return "CANCELLED".equalsIgnoreCase(this.status);
    }
}
