/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abtractfactory;

import interfaces.TechFactory;

/**
 *
 * @author macbook
 */
public class Client {
    TechFactory techFactory;

    public Client(TechFactory techFactory) {
        this.techFactory = techFactory;
    }
    
    public void buildDevices(int sp, int t, int sw) {
        for (int i = 0; i < sp; i++) {
            techFactory.createSmartPhone().build();
        }
        
        for (int i = 0; i < t; i++) {
            techFactory.createTablet().build();
        }
        
        for (int i = 0; i < sw; i++) {
            techFactory.createSmartWatch().build();
        }
    }
}
