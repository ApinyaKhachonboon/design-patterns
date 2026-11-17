/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author macbook
 */
public class CloudForming extends CloudState {

    @Override
    public void addMoisture(double amount) {
        cloud.setMoistureLevel(cloud.getMoistureLevel() + amount);
        
        System.out.printf("[Forming] รับไอน้ำเพิ่ม %.1f%% -> ปัจจุบัน: %.1f%%\n", amount, cloud.getMoistureLevel());

        // คำนวณจุดอิ่มตัวตาม First Principle: อากาศร้อนอุ้มน้ำได้มาก จุดอิ่มตัวจะสูงกว่าเมืองหนาว
        double saturationThreshold = 80.0 - (cloud.getAltitude() / 100.0) + (cloud.getTemperature() * 0.5);

        if (cloud.getMoistureLevel() >= saturationThreshold) {
            System.out.printf("--> ไอน้ำเกินขีดจำกัด (เกณฑ์: %.1f%%) เมฆหนาตัวกลายเป็น Overcast\n", saturationThreshold);
            
            cloud.changeState(new CloudOvercast());
        }
    }

    @Override
    public void dropRain() {
        System.out.println("[Forming] เมฆยังบางเกินไป ยังไม่พร้อมตก");
    }

    @Override
    public void clearUp() {
        System.out.println("[Forming] แดดจัด ลมพัดไอน้ำสลายตัว");
        
        cloud.setMoistureLevel(0.0);
    }
}
