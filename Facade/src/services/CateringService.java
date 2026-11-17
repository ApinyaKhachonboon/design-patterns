/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

/**
 *
 * @author macbook
 */
public class CateringService {

    private String menuType;
    private double pricePerHead;
    private boolean isDietaryOptionIncluded;

    public void selectMenu(String menuType, double pricePerHead, boolean dietaryOption) {
        this.menuType = menuType;
        this.pricePerHead = pricePerHead;
        this.isDietaryOptionIncluded = dietaryOption;
        
        System.out.println("[บริการอาหาร] เลือกเมนู: " + menuType + "ราคาต่อ 1 ท่าน: " + pricePerHead + " บาท");
        
        if (dietaryOption) {
            System.out.println("[บริการอาหาร] *รวมเมนูพิเศษสำหรับคนแพ้อาหาร/มังสวิรัติ/ฮาลาลแล้ว");
        }
    }

    public void cancelFood() {
        System.out.println("[บริการอาหาร/เครื่องดื่ม] ยกเลิกรายการสั่งทำอาหารเรียบร้อย");
    }

    public double calculateFoodCost(int guestCount) {
        return pricePerHead * guestCount;
    }
}
