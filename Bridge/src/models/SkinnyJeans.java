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
public class SkinnyJeans extends Jeans {

    private double ankleWidthInches; // ความกว้างปลายขา (นิ้ว)
    private boolean hasZipperAnkle;  // สถานะว่ามีซิปที่ปลายขาหรือไม่ (ช่วยให้ใส่ง่ายขึ้น)

    public SkinnyJeans(
            DenimFabric fabric,
            String modelName,
            int waistSizeInches,
            int lengthInches,
            double basePrice,
            double ankleWidthInches,
            boolean hasZipperAnkle
    ) {
        super(fabric, modelName, waistSizeInches, lengthInches, basePrice);

        this.ankleWidthInches = ankleWidthInches;
        this.hasZipperAnkle = hasZipperAnkle;
    }

    public double getAnkleWidthInches() {
        return ankleWidthInches;
    }

    public void setAnkleWidthInches(double ankleWidthInches) {
        this.ankleWidthInches = ankleWidthInches;
    }

    public boolean isHasZipperAnkle() {
        return hasZipperAnkle;
    }

    public void setHasZipperAnkle(boolean hasZipperAnkle) {
        this.hasZipperAnkle = hasZipperAnkle;
    }

    @Override
    public double calculateFinalPrice() {
        return basePrice + 200.0; // ทรง Skinny มีค่าคัตติ้งเพิ่ม 200 บาท
    }

    @Override
    public void displayDetails() {
        System.out.println("=== กางเกงยีนส์ทรง Skinny (เดฟ) ===");
        System.out.println("รุ่น: " + modelName + " | เอว: " + waistSizeInches + "\" | ยาว: " + lengthInches + "\"");
        System.out.println("ความกว้างปลายขา: " + ankleWidthInches + "\" " + (hasZipperAnkle ? "(มีซิปปลายขา)" : ""));
        System.out.println("เนื้อผ้า: " + fabric.getTexture());
        System.out.println("ความยืด: " + fabric.getStretchLevel());
        System.out.println("การดูแล: " + fabric.getWashInstruction());
        System.out.println("ราคาขายสุทธิ: " + calculateFinalPrice() + " บาท\n");
    }
}
