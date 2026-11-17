/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

/**
 *
 * @author macbook
 */
public abstract class BaseFrameAdapter {

    protected double glassPricePerSqFt = 150.0; // ราคากระจกกลาง
    protected double alumPricePerKg = 200.0;    // ราคาอลูมิเนียมกลาง

    public abstract double getGlassSqFt();

    public abstract double getAluminumWeightKg();

    public double getFramePrice() {
        return getAluminumWeightKg() * alumPricePerKg;
    }

    public double getGlassPrice() {
        return getGlassSqFt() * glassPricePerSqFt;
    }

    public double getPrice() {
        return getFramePrice() + getGlassPrice();
    }
}
