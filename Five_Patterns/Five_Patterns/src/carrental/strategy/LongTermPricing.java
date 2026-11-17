package carrental.strategy;

public class LongTermPricing implements PricingStrategy {

    // ใช้เมื่อเช่า 30 วันขึ้นไป ลด 20%
    @Override
    public double calculate(double rate, int days) {
        return rate * days * 0.8;
    }
}
