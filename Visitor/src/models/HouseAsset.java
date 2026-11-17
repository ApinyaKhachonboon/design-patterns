package models;


import interfaces.InsuranceVisitor;
import interfaces.InsuredElement;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author macbook
 */
public class HouseAsset implements InsuredElement {

    private final String address;
    private final double areaSqm;
    private final boolean isFloodZone;

    public HouseAsset(String address, double areaSqm, boolean isFloodZone) {
        this.address = address;
        this.areaSqm = areaSqm;
        this.isFloodZone = isFloodZone;
    }

    public String getAddress() {
        return address;
    }

    public double getAreaSqm() {
        return areaSqm;
    }

    public boolean isFloodZone() {
        return isFloodZone;
    }

    @Override
    public void accept(InsuranceVisitor v) {
        v.visit(this);
    }
}
