/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package singleton;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author macbook
 */
public class CarParkManager {

    private static CarParkManager instance;

    private int totalSpaces;
    private List<Car> parkedCars;

    private CarParkManager() {
        this.parkedCars = new ArrayList<>();
        
        System.out.println("ระบบจัดการที่จอดรถเริ่มต้นทำงาน");
    }

    public static CarParkManager getInstance() {
        if (instance == null) {
            instance = new CarParkManager();
        }
        
        return instance;
    }
    
    public void setTotalSpaces(int totalSpaces) {
        this.totalSpaces = totalSpaces;
        
        System.out.println("ตั้งค่าขนาดที่จอด (ความจุ: " + totalSpaces + " คัน)");
    }

    public boolean parkCar(Car car) {
        if (parkedCars.size() < totalSpaces) {
            parkedCars.add(car);
            
            System.out.println("รถทะเบียน " + car.getLicensePlate() + " จอดเรียบร้อยแล้ว");
            
            return true;
        }
        
        System.out.println("ขออภัย ที่จอดรถเต็มแล้ว!");
        
        return false;
    }

    public void removeCar(String licensePlate) {
        for (Car c : parkedCars) {
            if(c.getLicensePlate().equals(licensePlate)) {
                parkedCars.remove(c);
                
                System.out.println("รถทะเบียน " + licensePlate + " ออกจากที่จอดแล้ว");
                
                return;
            }
        }
        
        System.out.println("ไม่พบรถทะเบียน " + licensePlate);
    }

    public void showParkedCars() {
        System.out.println("จำนวนรถปัจจุบัน: " + parkedCars.size() + "/" + totalSpaces);
        
        for (Car c : parkedCars) {
            System.out.println("- " + c);
        }
    }
}
