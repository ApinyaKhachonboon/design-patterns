/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abtractfactory;

import product.Tablet;

/**
 *
 * @author macbook
 */
public class AppleTablet extends Tablet {

    @Override
    public void build() {
        System.out.println("สร้าง IPad");
    }
    
}
