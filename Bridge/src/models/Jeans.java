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
public abstract class Jeans {

    protected DenimFabric fabric; // Bridge Link เชื่อมต่อไปยังวัตถุเนื้อผ้า (Implementation)
    protected String modelName;   // ชื่อรุ่น/รหัสสินค้า (เช่น "SK-Flex-01")
    protected int waistSizeInches; // ขนาดรอบเอว (นิ้ว)
    protected int lengthInches;    // ความยาวกางเกง/Inseam (นิ้ว)
    protected double basePrice;    // ราคาตั้งต้นของทรงกางเกง (บาท)

    public Jeans(DenimFabric fabric, String modelName, int waistSizeInches, int lengthInches, double basePrice) {
        this.fabric = fabric;
        this.modelName = modelName;
        this.waistSizeInches = waistSizeInches;
        this.lengthInches = lengthInches;
        this.basePrice = basePrice;
    }

    public abstract void displayDetails();

    public double calculateFinalPrice() {
        return basePrice;
    }
}
