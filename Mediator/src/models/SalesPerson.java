/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author macbook
 */
public class SalesPerson extends ShowroomColleague {

    private String salesName;
    private double commissionRate;

    public SalesPerson(String salesName, double commissionRate) {
        this.salesName = salesName;
        this.commissionRate = commissionRate;
    }

    public void accompanyCustomer() {
        System.out.println(salesName + " (Sales) พาชมและแนะนำรถ");
    }

    public void createQuotation() {
        System.out.println(salesName + " (Sales) จัดทำใบเสนอราคา");
        
        mediator.notify(this, "quotation_ready");
    }

    public void explainCarFeatures() {
        System.out.println(salesName + " (Sales) อธิบายฟังก์ชันการใช้งานรถ");
    }
}
