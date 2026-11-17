/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package singleton;

/**
 *
 * @author macbook
 */
public class Car {

    private String licensePlate;
    private String color;

    public Car(String licensePlate, String color) {
        this.licensePlate = licensePlate;
        this.color = color;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    @Override
    public String toString() {
        return "Car [Plate=" + licensePlate + ", Color=" + color + "]";
    }
}
