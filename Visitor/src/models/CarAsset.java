/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import interfaces.InsuranceVisitor;
import interfaces.InsuredElement;

/**
 *
 * @author macbook
 */
public class CarAsset implements InsuredElement {

    private final String licensePlate;
    private final int engineCc;
    private final int claimHistory;

    public CarAsset(String licensePlate, int engineCc, int claimHistory) {
        this.licensePlate = licensePlate;
        this.engineCc = engineCc;
        this.claimHistory = claimHistory;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public int getEngineCc() {
        return engineCc;
    }

    public int getClaimHistory() {
        return claimHistory;
    }

    @Override
    public void accept(InsuranceVisitor v) {
        v.visit(this);
    }
}
