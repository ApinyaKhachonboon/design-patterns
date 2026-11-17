package carrental.singleton;

import carrental.core.Rental;
import carrental.car.Car;
import carrental.observer.Customer;
import carrental.observer.RentalPublisher;
import carrental.strategy.PricingStrategy;
import java.util.ArrayList;
import java.util.List;

/**
 * Singleton: ศูนย์กลางของระบบเช่ารถ มีได้เพียงอินสแตนซ์เดียว
 */
public class RentalAgency {

    private static RentalAgency instance;
    private List<Car> cars = new ArrayList<>();
    private RentalPublisher publisher;

    // private constructor: ห้ามสร้างจากภายนอก ต้องเรียกผ่าน getInstance()
    private RentalAgency() {
    }

    public static RentalAgency getInstance() {
        if (instance == null) {
            instance = new RentalAgency();
        }

        return instance;
    }

    // setter injection: publisher ถูกสร้างจากภายนอกแล้วส่งเข้ามา
    public void setPublisher(RentalPublisher p) {
        this.publisher = p;
    }

    public void addCar(Car car) {
        cars.add(car);

        if (publisher != null) {
            publisher.notify("มีรถใหม่ให้เช่า: " + car.getDescription());
        }
    }

    public List<Car> getAvailableCars() {
        List<Car> available = new ArrayList<>();

        for (Car car : cars) {
            if (car.isAvailable()) {
                available.add(car);
            }
        }

        return available;
    }

    public Rental rentCar(Customer c, Car car, int days, PricingStrategy p) {
        if (!c.isLicenseValid()) {
            throw new IllegalStateException("ใบขับขี่ของ " + c.getName() + " หมดอายุแล้ว");
        }

        if (!car.isAvailable()) {
            throw new IllegalStateException(car.getDescription() + " ไม่ว่าง");
        }

        car.setAvailable(false);

        Rental rental = new Rental(c, car, days, p);

        return rental;
    }

    public void returnCar(Rental r) {
        String plateNo = r.getCar().getPlateNo();
        Car originalReturned = null;

        for (Car car : cars) {
            if (car.getPlateNo().equals(plateNo)) {
                originalReturned = car;
                
                break;
            }
        }

        if (originalReturned == null) {
            throw new IllegalStateException("เกิดข้อผิดพลาด ไม่พบรถทะเบียน " + plateNo + " ในระบบ");
        }

        originalReturned.inspect();
        originalReturned.clean();
        originalReturned.refuel();

        originalReturned.setAvailable(true);
        r.markReturned();

        if (publisher != null) {
            publisher.notify("รถว่างพร้อมให้เช่า: " + originalReturned.getDescription());
        }
    }
}
