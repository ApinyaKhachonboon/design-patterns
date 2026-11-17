package dtos;

import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author macbook
 */
public class PartyBookingResult {

    private String bookingId;
    private String partyName;
    private Date confirmedDate;
    private double totalCost;
    private String bookingStatus;
    private String invoicePdfUrl;

    public PartyBookingResult(
            String bookingId, 
            String partyName, 
            Date confirmedDate,
            double totalCost, 
            String bookingStatus, 
            String invoicePdfUrl
    ) {
        this.bookingId = bookingId;
        this.partyName = partyName;
        this.confirmedDate = confirmedDate;
        this.totalCost = totalCost;
        this.bookingStatus = bookingStatus;
        this.invoicePdfUrl = invoicePdfUrl;
    }

    public String getSummary() {
        return String.format(
                "--- เอกสารยืนยันการจองงานเลี้ยง ---"
                + "\nรหัสการจอง: %s"
                + "\nชื่อชื่องาน: %s"
                + "\nวันที่จัดงาน: %s"
                + "\nราคารวมทั้งหมด: %.2f บาท\nสถานะการจอง: %s"
                + "\nลิงก์ใบเสร็จ/ใบแจ้งหนี้: %s",
                bookingId, 
                partyName, 
                confirmedDate, 
                totalCost, 
                bookingStatus, 
                invoicePdfUrl);
    }

    public boolean isConfirmed() {
        return "CONFIRMED".equalsIgnoreCase(this.bookingStatus);
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getPartyName() {
        return partyName;
    }

    public Date getConfirmedDate() {
        return confirmedDate;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public String getInvoicePdfUrl() {
        return invoicePdfUrl;
    }
}
