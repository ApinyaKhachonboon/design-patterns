/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import interfaces.Originator;
import interfaces.Memento;

/**
 *
 * @author macbook
 */
public class Photo implements Originator {

    private int brightness;
    private int contrast;
    private String filter;

    public Photo(int brightness, int contrast, String filter) {
        this.brightness = brightness;
        this.contrast = contrast;
        this.filter = filter;
    }

    @Override
    public Memento save() {
        return new PhotoMemento(brightness, contrast, filter);
    }

    @Override
    public void restore(Memento m) {
        PhotoMemento pm = (PhotoMemento) m;
        
        this.brightness = pm.getBrightness();
        this.contrast = pm.getContrast();
        this.filter = pm.getFilter();
    }

    public void setAdjustments(int brightness, int contrast, String filter) {
        this.brightness = brightness;
        this.contrast = contrast;
        this.filter = filter;
    }

    public void show() {
        System.out.printf("Photo State -> Brightness: %d, Contrast: %d, Filter: %s%n",
                brightness,
                contrast,
                filter
        );
    }
}
