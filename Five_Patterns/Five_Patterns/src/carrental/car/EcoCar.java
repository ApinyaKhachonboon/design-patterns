package carrental.car;

public class EcoCar extends BaseCar {

    private final double fuelEconomy;   // กม./ลิตร

    public EcoCar(String plateNo, String model, int seats, String transmission, double fuelEconomy) {
        super(plateNo, model, seats, transmission);
        
        this.fuelEconomy = fuelEconomy;
    }

    @Override
    public void inspect() {
        System.out.println("  ตรวจสภาพรถ " + getPlateNo() + ": ยาง เบรก ไฟ");
    }

    @Override
    public String getDescription() {
        return "รถอีโคคาร์ " + getBasicInfo() + ", " + fuelEconomy + " กม./ลิตร)";
    }

    @Override
    public double getDailyRate() {
        return 800;
    }
}