/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abtractfactory;

import interfaces.TechFactory;
import product.SmartPhone;
import product.SmartWatch;
import product.Tablet;

/**
 *
 * @author macbook
 */
public class AppleFactory implements TechFactory {

    @Override
    public SmartPhone createSmartPhone() {
        return new AppleSmartPhone();
    }

    @Override
    public Tablet createTablet() {
        return new AppleTablet();
    }

    @Override
    public SmartWatch createSmartWatch() {
        return new AppleSmartWatch();
    }
    
}
