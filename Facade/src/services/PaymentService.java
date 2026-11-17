/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

/**
 *
 * @author macbook
 */
public class PaymentService {
    private String invoiceId;
    private double totalAmount;
    private String paymentStatus;

    public PaymentService() {
        this.paymentStatus = "UNPAID";
    }

    public boolean processDeposit(double amount) {
        this.paymentStatus = "DEPOSIT_PAID";
        
        System.out.println("[บริการชำระเงิน] ชำระเงินมัดจำจำนวน " + amount + " บาท สำเร็จแล้ว");
        
        return true;
    }

    public String issueInvoice(double totalAmount) {
        this.totalAmount = totalAmount;
        this.invoiceId = "INV-TH-" + (int)(Math.random() * 90000 + 10000);
        
        System.out.println("[บริการชำระเงิน] ออกใบแจ้งหนี้รหัส " + invoiceId + " ยอดรวมทั้งสิ้น: " + totalAmount + " บาท");
        
        return "https://billing.organizer-th.com/pdf/" + invoiceId;
    }

    public void processRefund(String bookingId) {
        this.paymentStatus = "REFUNDED";
        
        System.out.println("[บริการชำระเงิน] ดำเนินการคืนเงินมัดจำสำหรับรหัสการจอง: " + bookingId);
    }
}
