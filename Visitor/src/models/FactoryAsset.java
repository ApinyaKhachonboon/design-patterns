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
public class FactoryAsset implements InsuredElement {

    private final String factoryName;
    private final double machineValue;
    private final int hazardLevel; // ระดับความอันตราย 1 (ต่ำ) ถึง 5 (สูง)

    public FactoryAsset(String factoryName, double machineValue, int hazardLevel) {
        this.factoryName = factoryName;
        this.machineValue = machineValue;
        this.hazardLevel = hazardLevel;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public double getMachineValue() {
        return machineValue;
    }

    public int getHazardLevel() {
        return hazardLevel;
    }

    @Override
    public void accept(InsuranceVisitor v) {
        v.visit(this);
    }
}
