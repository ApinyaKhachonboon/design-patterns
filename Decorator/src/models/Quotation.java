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
public class Quotation implements SaleDocument {

    private String documentNo;
    private String customerName;
    private String customerPhone;
    private String customerEmail;
    private String issueDate;
    private double totalPrice;

    public Quotation(
            String documentNo, 
            String customerName, 
            String customerPhone, 
            String customerEmail, 
            String issueDate, 
            double totalPrice
    ) {
        this.documentNo = documentNo;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.issueDate = issueDate;
        this.totalPrice = totalPrice;
    }

    @Override
    public String getDocumentNo() {
        return documentNo;
    }

    @Override
    public double getFinalPrice() {
        return totalPrice;
    }

    @Override
    public String render() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("=================================================================\n");
        sb.append("                  QUOTATION (ใบเสนอราคา)\n");
        sb.append("=================================================================\n");
        sb.append(String.format("เลขที่เอกสาร (Doc No)\t: %s\n", documentNo));
        sb.append(String.format("ชื่อลูกค้า (Customer)\t: %s\n", customerName));
        sb.append(String.format("เบอร์โทรศัพท์ (Phone)\t: %s\n", customerPhone));
        sb.append(String.format("อีเมล (Email)\t: %s%n", customerEmail));
        sb.append(String.format("วันที่ออกเอกสาร (Date)\t: %s\n", issueDate));
        sb.append("-----------------------------------------------------------------\n");
        sb.append(String.format("ยอดรวมราคาสินค้า (Total)\t: %,.2f บาท%n", totalPrice));
        
        return sb.toString();
    }
}
