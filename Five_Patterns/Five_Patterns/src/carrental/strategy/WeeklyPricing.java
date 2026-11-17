package carrental.strategy;

public class WeeklyPricing implements PricingStrategy {

    // ใช้เมื่อเช่า 7 วันขึ้นไป ลด 10%
    @Override
    public double calculate(double rate, int days) {
        return rate * days * 0.9;
    }
}
