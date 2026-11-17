/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author macbook
 */
public class ThaiShopOrder {

    private double widthMm;
    private double heightMm;

    public ThaiShopOrder(double widthMm, double heightMm) {
        this.widthMm = widthMm;
        this.heightMm = heightMm;
    }

    public double getWidthMm() {
        return widthMm;
    }

    public double getHeightMm() {
        return heightMm;
    }
}
