/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author macbook
 */
public class DeliveryStaff extends ShowroomColleague {
    private String staffName;
    private String bayArea;

    public DeliveryStaff(String staffName, String bayArea) {
        this.staffName = staffName;
        this.bayArea = bayArea;
    }

    public void handoverKey() {
        System.out.println(staffName + " (Delivery) ส่งมอบกุญแจรถ");
    }

    public void explainManual() {
        System.out.println(staffName + " (Delivery) แนะนำคู่มือการใช้งานเบื้องต้น");
    }

    public void completeDelivery() {
        System.out.println(staffName + " (Delivery) กระบวนการส่งมอบรถเสร็จสิ้น");
        
        mediator.notify(this, "delivery_completed");
    }
}
