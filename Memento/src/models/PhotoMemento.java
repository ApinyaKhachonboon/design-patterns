/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import interfaces.Memento;

/**
 *
 * @author macbook
 */
public class PhotoMemento implements Memento {

    private int brightness;
    private int contrast;
    private String filter;

    public PhotoMemento(int brightness, int contrast, String filter) {
        this.brightness = brightness;
        this.contrast = contrast;
        this.filter = filter;
    }

    public int getBrightness() {
        return brightness;
    }

    public int getContrast() {
        return contrast;
    }

    public String getFilter() {
        return filter;
    }
}
