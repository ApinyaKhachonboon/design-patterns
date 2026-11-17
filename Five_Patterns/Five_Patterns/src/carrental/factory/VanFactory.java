package carrental.factory;

import carrental.car.Car;
import carrental.car.Van;

public class VanFactory extends CarFactory {

    private final double cargoSpace;   // พื้นที่สัมภาระของรถตู้ที่สายการผลิตนี้สร้าง

    public VanFactory(double cargoSpace) {
        this.cargoSpace = cargoSpace;
    }

    @Override
    public Car createCar(String plateNo, String model, int seats, String transmission) {
        return new Van(plateNo, model, seats, transmission, cargoSpace);
    }
}