/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author macbook
 */
public class CloudOvercast extends CloudState {

    @Override
    public void addMoisture(double amount) {
        cloud.setMoistureLevel(cloud.getMoistureLevel() + amount);
        
        System.out.printf("[Overcast] ท้องฟ้ามืดครึ้ม อัดความชื้นเพิ่มอีก %.1f%% (รวม: %.1f%%)\n", 
                amount, 
                cloud.getMoistureLevel()
        );
    }

    @Override
    public void dropRain() {
        if (cloud.getTemperature() <= 0.0) {
            System.out.println("[Overcast] สภาพอากาศต่ำกว่าจุดเยือกแข็ง หิมะตก!");
        } else if (cloud.getTemperature() >= 32.0) {
            System.out.println("[Overcast] อากาศร้อนอบอ้าว! เกิดฝนฟ้าคะนอง");
        } else {
            System.out.println("[Overcast] ลมพยุงน้ำหนักไม่ไหว ฝนเริ่มเทลงมา");
        }
        
        cloud.changeState(new CloudRaining());
    }

    @Override
    public void clearUp() {
        System.out.println("[Overcast] ลมมรสุมพัดพาเมฆผ่านไปโดยไม่ตก");
        
        cloud.setMoistureLevel(20.0);
        
        cloud.changeState(new CloudForming());
    }
}
