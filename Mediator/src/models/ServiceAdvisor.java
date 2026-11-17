/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author macbook
 */

public class ServiceAdvisor extends ShowroomColleague {

    private String advisorName;
    private String stockLocation;

    public ServiceAdvisor(String advisorName, String stockLocation) {
        this.advisorName = advisorName;
        this.stockLocation = stockLocation;
    }

    public void inspectVehicle() {
        System.out.println(advisorName + " (Service) ตรวจสภาพและความพร้อมของรถ");
    }

    public void installAccessories() {
        System.out.println(advisorName + " (Service) ติดตั้งอุปกรณ์ตกแต่งและฟิล์ม");
    }

    public void prepareDeliveryDoc() {
        System.out.println(advisorName + " (Service) จัดเตรียมเอกสารส่งมอบรถ");
        
        mediator.notify(this, "vehicle_ready");
    }
}
