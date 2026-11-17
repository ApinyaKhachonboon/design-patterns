/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import models.ThaiShopOrder;

/**
 *
 * @author macbook
 */
// Adapter สำหรับงานช่างไทย (แปลง mm. -> Sq.Ft. และ kg.)
public class ThaiFrameAdapter extends BaseFrameAdapter {

    private ThaiShopOrder adaptee;

    public ThaiFrameAdapter(ThaiShopOrder adaptee) {
        super();
        
        this.adaptee = adaptee;
    }

    @Override
    public double getGlassSqFt() {
        // แปลง mm^2 -> ตารางฟุต (1 Sq.Ft. ≈ 92,903.04 mm^2)
        double areaMm2 = adaptee.getWidthMm() * adaptee.getHeightMm();
        return areaMm2 / 92903.04;
    }

    @Override
    public double getAluminumWeightKg() {
        // คำนวณความยาวรอบกรอบประตู (เมตร) แล้วคูณด้วยน้ำหนักเฉลี่ยอลูมิเนียมต่อเมตร (สมมติ 1.2 kg/m)
        double perimeterMeters = (2 * (adaptee.getWidthMm() + adaptee.getHeightMm())) / 1000.0;
        
        return perimeterMeters * 1.2;
    }
}
