package carrental.decorator;

import carrental.car.Car;

/**
 * Decorator: ห่อรถไว้และส่งต่อทุกเมธอดให้รถที่ห่ออยู่
 */
public class CarDecorator implements Car {

    private Car car;

    public CarDecorator(Car c) {
        this.car = c;
    }

    @Override
    public void clean() {
        car.clean();
    }

    @Override
    public void refuel() {
        car.refuel();
    }

    @Override
    public boolean isAvailable() {
        return car.isAvailable();
    }

    @Override
    public void setAvailable(boolean available) {
        car.setAvailable(available);
    }

    @Override
    public void inspect() {
        car.inspect();
    }

    @Override
    public String getDescription() {
        return car.getDescription();
    }

    @Override
    public double getDailyRate() {
        return car.getDailyRate();
    }

    @Override
    public String getPlateNo() {
        return car.getPlateNo();
    }
}
