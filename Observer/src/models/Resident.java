/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author macbook
 */
public class Resident extends Person {

    private String roomNo;

    public Resident(String roomNo, String name, String email, String phone) {
        super(name, email, phone);
        
        this.roomNo = roomNo;
    }

    @Override
    public void update(String message) {
        System.out.println("[แจ้งเตือนลูกบ้านห้อง " + roomNo + " - " + name + "]");
        System.out.println("  -> SMS (" + phone + "): " + message);
        System.out.println("  -> Email (" + email + "): " + message);
    }
}
