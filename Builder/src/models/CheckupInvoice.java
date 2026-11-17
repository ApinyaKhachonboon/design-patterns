/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author macbook
 */
public class CheckupInvoice {

    private String billedTo;
    private double vitalSignsFee;
    private double bloodTestFee;
    private double xrayFee;
    private double ekgFee;
    private double ultrasoundFee;

    public String getBilledTo() {
        return billedTo;
    }

    public void setBilledTo(String billedTo) {
        this.billedTo = billedTo;
    }

    public double getVitalSignsFee() {
        return vitalSignsFee;
    }

    public void setVitalSignsFee(double vitalSignsFee) {
        this.vitalSignsFee = vitalSignsFee;
    }

    public double getBloodTestFee() {
        return bloodTestFee;
    }

    public void setBloodTestFee(double bloodTestFee) {
        this.bloodTestFee = bloodTestFee;
    }

    public double getXrayFee() {
        return xrayFee;
    }

    public void setXrayFee(double xrayFee) {
        this.xrayFee = xrayFee;
    }

    public double getEkgFee() {
        return ekgFee;
    }

    public void setEkgFee(double ekgFee) {
        this.ekgFee = ekgFee;
    }

    public double getUltrasoundFee() {
        return ultrasoundFee;
    }

    public void setUltrasoundFee(double ultrasoundFee) {
        this.ultrasoundFee = ultrasoundFee;
    }

    public double getTotalAmount() {
        return vitalSignsFee + bloodTestFee + xrayFee + ekgFee + ultrasoundFee;
    }

    public void printInvoice() {
        System.out.println("==================================================");
        System.out.println("ใบแจ้งค่าใช้จ่าย/ใบเสร็จรับเงิน (Checkup Invoice)");
        System.out.println("==================================================");
        System.out.println("เรียกเก็บถึง: " + billedTo);
        System.out.println("รายการค่าบริการ:");
        
        if (vitalSignsFee > 0) {
            System.out.printf("  - %s %,.2f บาท%n", "ตรวจร่างกายเบื้องต้น (Vital Signs)", vitalSignsFee);
        }
        
        if (bloodTestFee > 0) {
            System.out.printf("  - %s %,.2f บาท%n", "ตรวจเลือด (CBC/FBS/Lipid)", bloodTestFee);
        }
        
        if (xrayFee > 0) {
            System.out.printf("  - %s %,.2f บาท%n", "เอกซเรย์ปอด (Chest X-Ray)", xrayFee);
        }
        
        if (ekgFee > 0) {
            System.out.printf("  - %s %,.2f บาท%n", "คลื่นไฟฟ้าหัวใจ (EKG)", ekgFee);
        }
        
        if (ultrasoundFee > 0) {
            System.out.printf("  - %s %,10.2f บาท%n", "อัลตราซาวด์ช่องท้อง (Ultrasound)", ultrasoundFee);
        }
        
        System.out.println("--------------------------------------------------");
        System.out.printf("  ยอดรวมสุทธิทั้งสิ้น: %,.2f บาท%n%n", getTotalAmount());
    }
}
