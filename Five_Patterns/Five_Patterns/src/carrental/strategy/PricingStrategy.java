package carrental.strategy;

public interface PricingStrategy {
    double calculate(double rate, int days);
}
