/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author macbook
 */
public class CloudRaining extends CloudState {
    @Override
    public void addMoisture(double amount) {
        System.out.println("[Raining] ฝนกำลังตกหนัก ไม่สามารถสะสมไอน้ำเพิ่มได้");
    }

    @Override
    public void dropRain() {
        // อุณหภูมิสูงและเมฆต่ำทำให้อัตราฝนตกเทลงมาเร็ว
        double rainfallRate = (cloud.getTemperature() > 30.0) ? 35.0 : 20.0;
        
        cloud.setMoistureLevel(cloud.getMoistureLevel() - rainfallRate);

        if (cloud.getMoistureLevel() <= 0.0) {
            cloud.setMoistureLevel(0.0);
            
            System.out.println("[Raining] ฝนเทลงมาจนหยดสุดท้าย เมฆหมดตัวแล้ว");
            
            clearUp();
        }
        
        else if (cloud.getMoistureLevel() <= 30.0) {
            System.out.printf("[Raining] ฝนตกๆ หยุดๆ กลับไปเป็นสถานะเมฆดำ ความชื้นในเมฆเหลือ %.1f%%\n", 
                    cloud.getMoistureLevel()
            );
            
            cloud.changeState(new CloudOvercast());
        } else {
            System.out.printf("[Raining] ฝนกำลังเทลงมา... ความชื้นในเมฆเหลือ %.1f%%\n", cloud.getMoistureLevel());
        }
    }

    @Override
    public void clearUp() {
        System.out.println("[Raining] ฝนหยุดตก ฟ้าหลังฝนเริ่มสว่าง");
        
        cloud.changeState(new CloudForming());
    }
}