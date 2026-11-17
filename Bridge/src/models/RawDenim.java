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
public class RawDenim implements DenimFabric {

    private int weightOz;       // น้ำหนักผ้าเป็นออนซ์ (เช่น 14 Oz, 21 Oz)
    private int shrinkagePct;   // เปอร์เซ็นต์การหดตัวของผ้าหลังซักครั้งแรก (Unsanforized)

    public RawDenim(int weightOz, int shrinkagePct) {
        this.weightOz = weightOz;
        this.shrinkagePct = shrinkagePct;
    }

    public int getWeightOz() {
        return weightOz;
    }

    public void setWeightOz(int weightOz) {
        this.weightOz = weightOz;
    }

    public int getShrinkagePct() {
        return shrinkagePct;
    }

    public void setShrinkagePct(int shrinkagePct) {
        this.shrinkagePct = shrinkagePct;
    }

    @Override
    public String getTexture() {
        return "ผ้าดิบเนื้อหนาและแข็ง (" + weightOz + " Oz)";
    }

    @Override
    public String getWashInstruction() {
        return "ห้ามซักบ่อย ควรใส่ปั้นเฟดอย่างน้อย 6 เดือน (อัตราหด " + shrinkagePct + "%)";
    }

    @Override
    public String getStretchLevel() {
        return "ไม่ยืด (0% Spandex)";
    }
}
