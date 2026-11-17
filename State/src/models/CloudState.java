/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author macbook
 */
public abstract class CloudState {

    protected Cloud cloud;

    public void setCloud(Cloud c) {
        this.cloud = c;
    }

    public abstract void addMoisture(double amount);

    public abstract void dropRain();

    public abstract void clearUp();
}
