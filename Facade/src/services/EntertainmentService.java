/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

/**
 *
 * @author macbook
 */
public class EntertainmentService {

    private String bandName;
    private String mcName;
    private double performanceFee;
    private String status;

    public void bookBand(String bandName, double fee) {
        this.bandName = bandName;
        this.performanceFee = fee;
        this.status = "BAND_BOOKED";
        
        System.out.println("[บริการการแสดง] ล็อกคิววงดนตรีสด '" + bandName + "' เรียบร้อยแล้ว");
    }

    public void assignMC(String mcName) {
        this.mcName = mcName;
        
        System.out.println("[บริการการแสดง] มอบหมายพิธีกรดำเนินรายการ: " + mcName);
    }

    public void cancelLineup() {
        this.status = "CANCELLED";
        
        System.out.println("[บริการการแสดง] แจ้งยกเลิกคิววงดนตรีและพิธีกรเรียบร้อย");
    }

    public double getPerformanceFee() {
        return performanceFee;
    }
}
