package carrental.factory;

import carrental.car.Car;
import carrental.car.EcoCar;

public class EcoCarFactory extends CarFactory {

    private final double fuelEconomy;   // อัตราสิ้นเปลืองของรถอีโคคาร์ที่สายการผลิตนี้สร้าง

    public EcoCarFactory(double fuelEconomy) {
        this.fuelEconomy = fuelEconomy;
    }

    @Override
    public Car createCar(String plateNo, String model, int seats, String transmission) {
        return new EcoCar(plateNo, model, seats, transmission, fuelEconomy);
    }
}