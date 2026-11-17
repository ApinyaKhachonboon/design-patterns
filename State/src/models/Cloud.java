/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author macbook
 */
public class Cloud {
    private CloudState state;
    private double moistureLevel;
    private double altitude;
    private double temperature;

    public Cloud(CloudState s, double altitude, double temperature) {
        this.altitude = altitude;
        this.temperature = temperature;
        this.moistureLevel = 0.0;
        
        changeState(s);
    }

    public void changeState(CloudState s) {
        this.state = s;
        this.state.setCloud(this);
    }

    public void addMoisture(double amount) {
        this.state.addMoisture(amount);
    }

    public void dropRain() {
        this.state.dropRain();
    }

    public void clearUp() {
        this.state.clearUp();
    }

    // Getters and Setters
    public double getMoistureLevel() {
        return moistureLevel;
    }

    public void setMoistureLevel(double moistureLevel) {
        this.moistureLevel = moistureLevel;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}