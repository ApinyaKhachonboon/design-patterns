package carrental.car;

public class Van extends BaseCar {

    private final double cargoSpace;   // พื้นที่สัมภาระ หน่วยลิตร

    public Van(String plateNo, String model, int seats, String transmission, double cargoSpace) {
        super(plateNo, model, seats, transmission);
        
        this.cargoSpace = cargoSpace;
    }

    @Override
    public void inspect() {
        System.out.println("  ตรวจสภาพรถ " + getPlateNo() + ": ยาง เบรก ประตูสไลด์ เข็มขัดนิรภัย " + getSeats() + " ที่นั่ง");
    }

    @Override
    public String getDescription() {
        return "รถตู้ " + getBasicInfo() + ", สัมภาระ " + cargoSpace + " ลิตร)";
    }

    @Override
    public double getDailyRate() {
        return 2000;
    }
}