package carrental.car;

public class SUV extends BaseCar {

    private final String driveType;   // เช่น "2WD", "4WD"

    public SUV(String plateNo, String model, int seats, String transmission, String driveType) {
        super(plateNo, model, seats, transmission);
        
        this.driveType = driveType;
    }

    @Override
    public void inspect() {
        System.out.println("  ตรวจสภาพรถ " + getPlateNo() + ": ยาง เบรก ระบบขับเคลื่อน " + driveType);
    }

    @Override
    public String getDescription() {
        return "รถ SUV " + getBasicInfo() + ", " + driveType + ")";
    }

    @Override
    public double getDailyRate() {
        return 1500;
    }
}