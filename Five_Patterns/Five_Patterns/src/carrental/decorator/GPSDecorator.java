package carrental.decorator;

import carrental.car.Car;

public class GPSDecorator extends CarDecorator {

    private String deviceId;

    public GPSDecorator(Car c, String deviceId) {
        super(c);
        
        this.deviceId = deviceId;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + GPS (" + deviceId + ")";
    }

    @Override
    public double getDailyRate() {
        return super.getDailyRate() + 100;
    }
}
