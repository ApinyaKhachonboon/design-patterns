package carrental.factory;

import carrental.car.Car;

/**
 * Factory Method: Creator
 */
public abstract class CarFactory {

    // เตรียมรถให้พร้อมเช่า โดยใช้รถผ่าน interface Car เท่านั้น
    public Car orderCar(String plateNo, String model, int seats, String transmission) {
        Car car = createCar(plateNo, model, seats, transmission);
        car.inspect();
        car.clean();
        car.refuel();
        
        return car;
    }

    // factory method: คลาสลูกเป็นผู้ตัดสินใจว่าจะสร้างรถชนิดใด
    public abstract Car createCar(String plateNo, String model, int seats, String transmission);
}