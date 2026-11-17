package carrental.factory;

import carrental.car.Car;
import carrental.car.SUV;

public class SUVFactory extends CarFactory {

    private final String driveType;   // ระบบขับเคลื่อนของ SUV ที่สายการผลิตนี้สร้าง

    public SUVFactory(String driveType) {
        this.driveType = driveType;
    }

    @Override
    public Car createCar(String plateNo, String model, int seats, String transmission) {
        return new SUV(plateNo, model, seats, transmission, driveType);
    }
}