package carrental.car;

/**
 * เก็บข้อมูลและพฤติกรรมที่รถทุกคันมีร่วมกัน
 */
public abstract class BaseCar implements Car {

    private final String plateNo;
    private final String model;
    private final int seats;
    private final String transmission;   // "AT" = เกียร์อัตโนมัติ, "MT" = เกียร์ธรรมดา
    private boolean available;

    public BaseCar(String plateNo, String model, int seats, String transmission) {
        this.plateNo = plateNo;
        this.model = model;
        this.seats = seats;
        this.transmission = transmission;
        this.available = true;   // รถใหม่พร้อมให้เช่าเสมอ
    }

    @Override
    public void clean() {
        System.out.println("  ทำความสะอาดรถ " + plateNo);
    }

    @Override
    public void refuel() {
        System.out.println("  เติมน้ำมันรถ " + plateNo);
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    @Override
    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String getPlateNo() {
        return plateNo;
    }

    public String getModel() {
        return model;
    }

    public int getSeats() {
        return seats;
    }

    public String getTransmission() {
        return transmission;
    }

    // ข้อมูลพื้นฐานที่ทุกประเภทใช้ใน getDescription()
    public String getBasicInfo() {
        return getModel() + " (" + getPlateNo() + ", " + getSeats() + " ที่นั่ง, เกียร์ " + getTransmission();
    }

    @Override
    public abstract void inspect();

    @Override
    public abstract String getDescription();

    @Override
    public abstract double getDailyRate();
}
