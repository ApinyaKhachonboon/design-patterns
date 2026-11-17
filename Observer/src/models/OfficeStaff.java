/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author macbook
 */
public class OfficeStaff extends Person {
    private String role;

    public OfficeStaff(String name, String role, String email, String phone) {
        super(name, email, phone);
        
        this.role = role;
    }

    @Override
    public void update(String message) {
        System.out.println("[แจ้งเตือนเจ้าหน้าที่ - " + role + " " + name + "]");
        System.out.println("  -> SMS (" + phone + "): " + message);
        System.out.println("  -> Email (" + email + "): " + message);
    }
}
