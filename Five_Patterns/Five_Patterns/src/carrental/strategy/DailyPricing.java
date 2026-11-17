package carrental.strategy;

public class DailyPricing implements PricingStrategy {

    // ราคาเต็มรายวัน
    @Override
    public double calculate(double rate, int days) {
        return rate * days;
    }
}
