/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author macbook
 */
public abstract class SaleDocument {

    protected String transactionId;
    protected String docNo;
    protected String docDate;
    protected String customerName;
    protected String customerAddress;
    protected String preparedBy;
    protected String status = "Draft";
    protected List<Item> items = new ArrayList<>();
    protected double totalAmount;

    public SaleDocument() {
    }

    public SaleDocument(SaleDocument target) {
        if (target != null) {
            this.transactionId = target.transactionId;
            this.docNo = target.docNo;
            this.docDate = target.docDate;
            this.customerName = target.customerName;
            this.customerAddress = target.customerAddress;
            this.preparedBy = target.preparedBy;
            this.status = target.status;
            this.totalAmount = target.totalAmount;

            this.items = new ArrayList<>();

            for (Item item : target.items) {
                this.items.add(item.copy());
            }
        }
    }

    public abstract SaleDocument copy();

    public void showInfo() {
        System.out.println("------------------------------------");
        System.out.println("Document: " + this.getClass().getSimpleName() + " [" + status + "]");
        System.out.println("No: " + docNo + " | Date: " + docDate);
        System.out.println("Customer: " + customerName);
        System.out.println("CustomerAddress: " + customerAddress);
        System.out.println("preparedBy: " + preparedBy);
        System.out.println("Items: " + items);
        System.out.println("Total: " + totalAmount);
    }

    public double calculateTotalAmount() {
        double total = 0;

        for (Item item : items) {
            total += item.getPrice() * item.getAmount();
        }

        return total;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getDocNo() {
        return docNo;
    }

    public void setDocNo(String docNo) {
        this.docNo = docNo;
    }

    public String getDocDate() {
        return docDate;
    }

    public void setDocDate(String docDate) {
        this.docDate = docDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getPreparedBy() {
        return preparedBy;
    }

    public void setPreparedBy(String preparedBy) {
        this.preparedBy = preparedBy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
