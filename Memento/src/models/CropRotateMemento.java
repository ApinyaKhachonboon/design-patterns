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
public class CropRotateMemento implements Memento {

    private int rotationAngle;
    private int cropX;
    private int cropY;
    private int cropWidth;
    private int cropHeight;

    public CropRotateMemento(int rotationAngle, int cropX, int cropY, int cropWidth, int cropHeight) {
        this.rotationAngle = rotationAngle;
        this.cropX = cropX;
        this.cropY = cropY;
        this.cropWidth = cropWidth;
        this.cropHeight = cropHeight;
    }

    public int getRotationAngle() {
        return rotationAngle;
    }

    public int getCropX() {
        return cropX;
    }

    public int getCropY() {
        return cropY;
    }

    public int getCropWidth() {
        return cropWidth;
    }

    public int getCropHeight() {
        return cropHeight;
    }
}
