/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author macbook
 */
public class Customer extends ShowroomColleague {
    private String customerName;
    private String phone;
    private double budget;

    public Customer(String customerName, String phone, double budget) {
        this.customerName = customerName;
        this.phone = phone;
        this.budget = budget;
    }

    public void requestTestDrive() {
        System.out.println(customerName + " ขอทดลองขับรถ");
        
        mediator.notify(this, "request_test_drive");
    }

    public void buyCar() {
        System.out.println(customerName + " ตกลงซื้อรถ");
        
        mediator.notify(this, "buy_car");
    }

    public void signContract() {
        System.out.println(customerName + " เซ็นสัญญาซื้อขาย");
    }

    public void receiveKey() {
        System.out.println(customerName + " รับกุญแจรถเรียบร้อย");
    }
}
