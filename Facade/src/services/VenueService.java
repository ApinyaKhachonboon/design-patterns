/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.util.Date;

/**
 *
 * @author macbook
 */
public class VenueService {

    private String hallName;
    private int capacity;
    private double rentalFee;
    private boolean isBooked;

    public VenueService(String hallName, int capacity, double rentalFee) {
        this.hallName = hallName;
        this.capacity = capacity;
        this.rentalFee = rentalFee;
        this.isBooked = false;
    }

    public boolean reserveHall(Date date, int guestCount) {
        if (guestCount <= capacity && !isBooked) {
            this.isBooked = true;
            
            System.out.println("[บริการสถานที่] จองห้อง '" + hallName + "' สำเร็จแล้ว สำหรับแขกจำนวน " + guestCount + " ท่าน");
            
            return true;
        }
        
        System.out.println("[บริการสถานที่] ไม่สามารถจองห้องได้ (จำนวนคนเกิน หรือห้องถูกจองแล้ว)");
        
        return false;
    }

    public void releaseHall() {
        this.isBooked = false;
        System.out.println("[บริการสถานที่] คืนพื้นที่และยกเลิกการจองห้องสำเร็จ");
    }

    public double getRentalFee() {
        return rentalFee;
    }
}
