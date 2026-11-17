package carrental.decorator;

import carrental.car.Car;

public class ChildSeatDecorator extends CarDecorator {

    private int seatCount;
    private boolean installed = false;

    public ChildSeatDecorator(Car c, int seatCount) {
        super(c);
        
        this.seatCount = seatCount;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + คาร์ซีทเด็ก " + seatCount + " ตัว";
    }

    @Override
    public double getDailyRate() {
        return super.getDailyRate() + 50 * seatCount;
    }
}
