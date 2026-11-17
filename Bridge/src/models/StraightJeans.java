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
public class StraightJeans extends Jeans {

    private double legWidthInches; // ความกว้างช่วงขา (นิ้ว)
    private String flyType;        // ประเภทกระดุม/ซิปตรงเป้า (เช่น "Button Fly", "Zipper Fly")

    public StraightJeans(
            DenimFabric fabric,
            String modelName,
            int waistSizeInches,
            int lengthInches,
            double basePrice,
            double legWidthInches,
            String flyType
    ) {
        super(fabric, modelName, waistSizeInches, lengthInches, basePrice);

        this.legWidthInches = legWidthInches;
        this.flyType = flyType;
    }

    public double getLegWidthInches() {
        return legWidthInches;
    }

    public void setLegWidthInches(double legWidthInches) {
        this.legWidthInches = legWidthInches;
    }

    public String getFlyType() {
        return flyType;
    }

    public void setFlyType(String flyType) {
        this.flyType = flyType;
    }

    @Override
    public void displayDetails() {
        System.out.println("=== กางเกงยีนส์ทรง Straight (กระบอกตรง) ===");
        System.out.println("รุ่น: " + modelName + " | เอว: " + waistSizeInches + "\" | ยาว: " + lengthInches + "\"");
        System.out.println("ความกว้างทรงขา: " + legWidthInches + "\" | เป้า: " + flyType);
        System.out.println("เนื้อผ้า: " + fabric.getTexture());
        System.out.println("ความยืด: " + fabric.getStretchLevel());
        System.out.println("การดูแล: " + fabric.getWashInstruction());
        System.out.println("ราคาขายสุทธิ: " + calculateFinalPrice() + " บาท\n");
    }
}
