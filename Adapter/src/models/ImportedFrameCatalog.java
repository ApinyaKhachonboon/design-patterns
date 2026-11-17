/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author macbook
 */
// Adaptee 2: แคตตาล็อกสินค้านำเข้า (หน่วย inches / lbs.)
public class ImportedFrameCatalog {

    private double widthInches;
    private double heightInches;
    private double frameWeightLbs;

    public ImportedFrameCatalog(double widthInches, double heightInches, double frameWeightLbs) {
        this.widthInches = widthInches;
        this.heightInches = heightInches;
        this.frameWeightLbs = frameWeightLbs;
    }

    public double getWidthInches() {
        return widthInches;
    }

    public double getHeightInches() {
        return heightInches;
    }

    public double getFrameWeightLbs() {
        return frameWeightLbs;
    }
}
