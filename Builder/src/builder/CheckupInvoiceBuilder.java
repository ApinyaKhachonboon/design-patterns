/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package builder;

import interfaces.Builder;
import models.CheckupInvoice;

/**
 *
 * @author macbook
 */
public class CheckupInvoiceBuilder implements Builder {

    private CheckupInvoice invoice;
    private String billedName;

    public CheckupInvoiceBuilder(String billedName) {
        this.reset();
        
        this.billedName = billedName;
    }

    @Override
    public void reset() {
        this.invoice = new CheckupInvoice();
    }

    @Override
    public void buildPatientInfo() {
        this.invoice.setBilledTo(billedName);
    }

    @Override
    public void buildVitalSigns() {
        this.invoice.setVitalSignsFee(200.0);
    }

    @Override
    public void buildBloodTest() {
        this.invoice.setBloodTestFee(650.0);
    }

    @Override
    public void buildXray() {
        this.invoice.setXrayFee(500.0);
    }

    @Override
    public void buildEkg() {
        this.invoice.setEkgFee(800.0);
    }

    @Override
    public void buildUltrasound() {
        this.invoice.setUltrasoundFee(1800.0);
    }

    public CheckupInvoice getResult() {
        return this.invoice;
    }
}
