package carrental;

import carrental.car.Car;
import carrental.core.Rental;
import carrental.singleton.RentalAgency;
import carrental.decorator.ChildSeatDecorator;
import carrental.decorator.GPSDecorator;
import carrental.decorator.InsuranceDecorator;
import carrental.factory.CarFactory;
import carrental.factory.EcoCarFactory;
import carrental.factory.SUVFactory;
import carrental.factory.VanFactory;
import carrental.observer.Customer;
import carrental.observer.RentalPublisher;
import carrental.observer.Staff;
import carrental.strategy.DailyPricing;
import carrental.strategy.PricingStrategy;
import carrental.strategy.WeeklyPricing;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        // ===== 1. Observer =====
        System.out.println("\n=== 1. Observer: สร้าง publisher และลงทะเบียนผู้ติดตามข่าวสาร ===");
        Customer somchai = new Customer(
                "C001",
                "สมชาย ใจดี",
                "081-111-1111",
                "somchai@mail.com",
                "L-1001",
                LocalDate.now().plusYears(2)
        );

        Customer somying = new Customer(
                "C002",
                "สมหญิง รักเรียน",
                "082-222-2222",
                "somying@mail.com",
                "L-1002",
                LocalDate.now().plusYears(1)
        );

        Customer mana = new Customer(
                "C003",
                "มานะ อดทน",
                "083-333-3333",
                "mana@mail.com",
                "L-1003",
                LocalDate.now().minusDays(10)
        );   // ใบขับขี่หมดอายุ

        Staff staff = new Staff("S001", "วิชัย", "บางเขน");

        RentalPublisher publisher = new RentalPublisher();

        publisher.subscribe(staff);
        publisher.subscribe(somchai);
        publisher.subscribe(somying);

        System.out.println("  ผู้ติดตามข่าวสาร 3 ราย (คุณมานะไม่ได้ติดตาม)");

        // ===== 2. Singleton =====
        System.out.println("\n=== 2. Singleton: ระบบมี RentalAgency เพียงตัวเดียว ===");
        RentalAgency agency = RentalAgency.getInstance();
        agency.setPublisher(publisher);
        System.out.println("  เป็นอินสแตนซ์เดียวกันหรือไม่: " + (agency == RentalAgency.getInstance()));

        // ===== 3. Factory Method =====
        System.out.println("\n=== 3. Factory Method: สร้างรถและเตรียมให้พร้อมเช่า ===");
        CarFactory ecoFactory = new EcoCarFactory(20.5);
        CarFactory suvFactory = new SUVFactory("4WD");
        CarFactory vanFactory = new VanFactory(800);

        Car eco = ecoFactory.orderCar("กข-1234", "Toyota Yaris", 5, "AT");
        Car suv = suvFactory.orderCar("คง-5678", "Toyota Fortuner", 7, "AT");
        Car van = vanFactory.orderCar("จฉ-9012", "Toyota Commuter", 12, "MT");

        agency.addCar(eco);
        agency.addCar(suv);
        agency.addCar(van);

        System.out.println("  รถที่ว่าง:");

        for (Car car : agency.getAvailableCars()) {
            System.out.println("   - " + car.getDescription());
        }

        // ===== โปรโมชัน =====
        System.out.println("\n=== Observer: ประกาศโปรโมชันถึงผู้ติดตามทุกคน ===");
        publisher.notify("โปรโมชัน! เช่า 7 วันขึ้นไป ลด 10%");

        // เตรียม strategy ไว้ใช้ร่วมกันในขั้นที่ 4 ถึง 8
        PricingStrategy daily = new DailyPricing();
        PricingStrategy weekly = new WeeklyPricing();

        // ===== 4. Decorator + Strategy =====
        System.out.println("\n=== 4. Decorator + Strategy: คุณสมชายเช่ารถ SUV พร้อมประกันและ GPS 7 วัน ===");

        Car somchaiCar = new GPSDecorator(new InsuranceDecorator(suv, "ชั้น 1"), "GPS-01");

        Rental r1 = agency.rentCar(somchai, somchaiCar, 7, weekly);

        System.out.println("  รายการเช่า " + r1.getRentalId() + ": " + r1.getCar().getDescription());
        System.out.printf("  ค่าเช่ารายวัน: %,.2f บาท x %d วัน%n", r1.getCar().getDailyRate(), r1.getDays());
        System.out.printf("  ยอดรวม (ราคารายสัปดาห์ ลด 10%%): %,.2f บาท%n", r1.getTotal());

        // ===== 5. กรณีเช่ารถที่ไม่ว่าง =====
        System.out.println("\n=== 5. คุณสมหญิงพยายามเช่ารถ SUV คันเดียวกัน ===");

        try {
            agency.rentCar(somying, suv, 2, daily);
        } catch (IllegalStateException e) {
            System.out.println("  ปฏิเสธ: " + e.getMessage());
        }

        // ===== 6. Decorator + Strategy อีกรายการ =====
        System.out.println("\n=== 6. คุณสมหญิงเช่ารถอีโคคาร์พร้อมคาร์ซีทเด็ก 2 ตัว 8 วัน ===");
        Car somyingCar = new ChildSeatDecorator(eco, 2);
        Rental r2 = agency.rentCar(somying, somyingCar, 8, daily);

        System.out.println("  รายการเช่า " + r2.getRentalId() + ": " + r2.getCar().getDescription());
        System.out.printf("  ค่าเช่ารายวัน: %,.2f บาท x %d วัน%n", r2.getCar().getDailyRate(), r2.getDays());
        System.out.printf("  ยอดรวม (ราคารายวัน): %,.2f บาท%n", r2.getTotal());

        // ===== 7. ใบขับขี่หมดอายุ =====
        System.out.println("\n=== 7. คุณมานะ (ใบขับขี่หมดอายุ) พยายามเช่ารถตู้ ===");

        try {
            agency.rentCar(mana, van, 1, daily);
        } catch (IllegalStateException e) {
            System.out.println("  ปฏิเสธ: " + e.getMessage());
        }

        // ===== 8. สลับ Strategy ระหว่างรัน =====
        System.out.println("\n=== 8. Strategy: เช่าเกิน 7 วัน พนักงานเปลี่ยนเป็นราคารายสัปดาห์ระหว่างรัน ===");
        r2.setPricing(weekly);
        System.out.printf("  ยอดรวมใหม่ (ราคารายสัปดาห์ ลด 10%%): %,.2f บาท%n", r2.getTotal());

        // ===== 9. คืนรถ =====
        System.out.println("\n=== 9. คุณสมชายคืนรถ SUV ===");

        try {
            agency.returnCar(r1);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("  รถที่ว่าง:");

        for (Car car : agency.getAvailableCars()) {
            System.out.println("   - " + car.getDescription());
        }
    }
}
