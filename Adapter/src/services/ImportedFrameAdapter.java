/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import models.ImportedFrameCatalog;

/**
 *
 * @author macbook
 */
public class ImportedFrameAdapter extends BaseFrameAdapter {

    private ImportedFrameCatalog adaptee;

    public ImportedFrameAdapter(ImportedFrameCatalog adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public double getGlassSqFt() {
        // แปลง sq inches -> ตารางฟุต (1 Sq.Ft. = 144 sq inches)
        double areaSqInches = adaptee.getWidthInches() * adaptee.getHeightInches();
        
        return areaSqInches / 144.0;
    }

    @Override
    public double getAluminumWeightKg() {
        // แปลงปอนด์ (lbs) เป็น กิโลกรัม (kg) (1 lbs ≈ 0.453592 kg)
        return adaptee.getFrameWeightLbs() * 0.453592;
    }
}
