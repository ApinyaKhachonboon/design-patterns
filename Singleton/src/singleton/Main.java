/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package singleton;

/**
 *
 * @author macbook
 */
public class Main {

    public static void main(String[] args) {
        CarParkManager manager = CarParkManager.getInstance();
        manager.setTotalSpaces(2);

        Car car1 = new Car("1กข-123", "Red");
        Car car2 = new Car("2ขค-456", "Blue");
        Car car3 = new Car("3งจ-789", "White");

        manager.parkCar(car1);
        manager.parkCar(car2);
        manager.parkCar(car3); // จะจอดไม่ได้เพราะเต็ม

        manager.showParkedCars();

        CarParkManager cpm = CarParkManager.getInstance();
        cpm.removeCar("1กข-123");
        cpm.showParkedCars();
    }
}
