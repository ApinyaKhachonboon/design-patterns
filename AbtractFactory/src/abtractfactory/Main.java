/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package abtractfactory;

import interfaces.TechFactory;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author macbook
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<TechFactory> tfs = new ArrayList<>();
        
        tfs.add(new AppleFactory());
        tfs.add(new SamsungFactory());
        
        for(TechFactory tf: tfs) {
           Client c = new Client(tf);
           
           c.buildDevices(3, 1, 5);
        }
    }
    
}
