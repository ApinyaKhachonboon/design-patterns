/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import interfaces.DenimFabric;

/**
 *
 * @author macbook
 */

public class WideLegJeans extends Jeans {

    private double hipWidthInches; // ความกว้างช่วงสะโพก (นิ้ว)
    private boolean isHighWaist;   // สถานะว่าเป็นกางเกงเอวสูงหรือไม่

    public WideLegJeans(
            DenimFabric fabric,
            String modelName,
            int waistSizeInches,
            int lengthInches,
            double basePrice,
            double hipWidthInches,
            boolean isHighWaist
    ) {
        super(fabric, modelName, waistSizeInches, lengthInches, basePrice);
        
        this.hipWidthInches = hipWidthInches;
        this.isHighWaist = isHighWaist;
    }

    @Override
    public double calculateFinalPrice() {
        return basePrice + 150.0; // ทรงขากว้างใช้ผ้าเยอะขึ้น บวกเพิ่ม 150 บาท
    }

    public double getHipWidthInches() {
        return hipWidthInches;
    }

    public void setHipWidthInches(double hipWidthInches) {
        this.hipWidthInches = hipWidthInches;
    }

    public boolean isIsHighWaist() {
        return isHighWaist;
    }

    public void setIsHighWaist(boolean isHighWaist) {
        this.isHighWaist = isHighWaist;
    }

    @Override
    public void displayDetails() {
        System.out.println("=== กางเกงยีนส์ทรง Wide Leg (ขากว้าง/ทรงบอย) ===");
        System.out.println("รุ่น: " + modelName + " | เอว: " + waistSizeInches + "\" | ยาว: " + lengthInches + "\"");
        System.out.println("สะโพก: " + hipWidthInches + "\" | " + (isHighWaist ? "ทรงเอวสูง" : "ทรงเอวปกติ"));
        System.out.println("เนื้อผ้า: " + fabric.getTexture());
        System.out.println("ความยืด: " + fabric.getStretchLevel());
        System.out.println("การดูแล: " + fabric.getWashInstruction());
        System.out.println("ราคาขายสุทธิ: " + calculateFinalPrice() + " บาท\n");
    }
}
