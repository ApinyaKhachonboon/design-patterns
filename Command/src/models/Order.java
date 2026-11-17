/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author macbook
 */

public class Order {
    private String orderId;
    private String tableNo;
    private LocalDateTime createdAt;
    private List<OrderDetail> details;

    public Order(String orderId, String tableNo) {
        this.orderId = orderId;
        this.tableNo = tableNo;
        this.createdAt = LocalDateTime.now();
        this.details = new ArrayList<>();
    }

    public void addDetail(OrderDetail d) {
        this.details.add(d);
    }

    public List<OrderDetail> getDetails() {
        return details;
    }

    public double calculateActiveTotal() {
        double total = 0.0;
        
        for (OrderDetail detail : details) {
            if (!detail.isCancelled()) {
                total += detail.getSubtotal();
            }
        }
        
        return total;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getTableNo() {
        return tableNo;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
