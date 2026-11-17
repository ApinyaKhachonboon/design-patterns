package carrental.decorator;

import carrental.car.Car;

public class InsuranceDecorator extends CarDecorator {

    private String coverage; // ความคุ้มครอง

    public InsuranceDecorator(Car c, String coverage) {
        super(c);
        
        this.coverage = coverage;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + ประกัน" + coverage;
    }

    @Override
    public double getDailyRate() {
        return super.getDailyRate() + 300;
    }
}
