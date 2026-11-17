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
public class CropRotate implements Originator {
    private int rotationAngle;
    private int cropX;
    private int cropY;
    private int cropWidth;
    private int cropHeight;

    public CropRotate(int rotationAngle, int cropX, int cropY, int cropWidth, int cropHeight) {
        this.rotationAngle = rotationAngle;
        this.cropX = cropX;
        this.cropY = cropY;
        this.cropWidth = cropWidth;
        this.cropHeight = cropHeight;
    }

    @Override
    public Memento save() {
        return new CropRotateMemento(rotationAngle, cropX, cropY, cropWidth, cropHeight);
    }

    @Override
    public void restore(Memento m) {
        CropRotateMemento cm = (CropRotateMemento) m;
        
        this.rotationAngle = cm.getRotationAngle();
        this.cropX = cm.getCropX();
        this.cropY = cm.getCropY();
        this.cropWidth = cm.getCropWidth();
        this.cropHeight = cm.getCropHeight();
    }

    public void setAdjustments(int rotationAngle, int cropX, int cropY, int cropWidth, int cropHeight) {
        this.rotationAngle = rotationAngle;
        this.cropX = cropX;
        this.cropY = cropY;
        this.cropWidth = cropWidth;
        this.cropHeight = cropHeight;
    }

    public void show() {
        System.out.printf("Transform -> Angle: %d deg, Crop: [%d, %d, %dw, %dh]%n",
                rotationAngle, 
                cropX, 
                cropY, 
                cropWidth, 
                cropHeight
        );
    }
}
