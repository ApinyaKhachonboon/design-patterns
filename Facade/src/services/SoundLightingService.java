/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

/**
 *
 * @author macbook
 */
public class SoundLightingService {

    private int wattage;
    private boolean hasStageLight;
    private String status;

    public SoundLightingService(int wattage, boolean hasStageLight) {
        this.wattage = wattage;
        this.hasStageLight = hasStageLight;
        this.status = "IDLE";
    }

    public void installSoundSystem() {
        this.status = "INSTALLED";
        
        System.out.println("[บริการแสงสีเสียง] ติดตั้งระบบลำโพงเครื่องเสียงขนาด " + wattage + " วัตต์");
    }

    public void setupLights(String theme) {
        System.out.println("[บริการแสงสีเสียง] เซ็ตระบบไฟเวทีและไฟพาร์ตามธีม: " + theme);
    }

    public void dismantle() {
        this.status = "IDLE";
        
        System.out.println("[บริการแสงสีเสียง] รื้อถอนระบบเครื่องเสียงและไฟเวทีเรียบร้อย");
    }

    public double getServiceFee() {
        return 18000.00;
    }
}
