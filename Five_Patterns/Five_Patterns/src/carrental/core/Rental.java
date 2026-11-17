package carrental.core;

import carrental.car.Car;
import carrental.observer.Customer;
import carrental.strategy.PricingStrategy;
import java.time.LocalDate;

/**
 * ข้อมูลการเช่าแต่ละครั้ง และเป็น Context ของ Strategy pattern
 */
public class Rental {

    private static int counter = 0;

    private String rentalId;
    private Customer customer;
    private Car car;          // อาจเป็นรถที่ถูกห่อด้วย Decorator แล้ว
    private LocalDate startDate;
    private LocalDate returnDate;
    private int days;
    private PricingStrategy pricing;

    public Rental(Customer customer, Car car, int days, PricingStrategy pricing) {
        counter++;

        this.rentalId = String.format("R%03d", counter);
        this.customer = customer;
        this.car = car;
        this.days = days;
        this.pricing = pricing;
        this.startDate = LocalDate.now();
    }

    public void setPricing(PricingStrategy p) {
        this.pricing = p;
    }

    public double getTotal() {
        return pricing.calculate(car.getDailyRate(), days);
    }

    public void markReturned() {
        this.returnDate = LocalDate.now();
    }

    public String getRentalId() {
        return rentalId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Car getCar() {
        return car;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public int getDays() {
        return days;
    }

    public PricingStrategy getPricing() {
        return pricing;
    }
}
