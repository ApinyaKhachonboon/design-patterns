/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author macbook
 */
public class SeatType {

    private String name;
    private double price;
    private String privilege;

    public SeatType(String name, double price, String privilege) {
        this.name = name;
        this.price = price;
        this.privilege = privilege;
    }

    public void displaySeat(String row, int number, boolean isBooked) {
        String status = isBooked ? "[จองแล้ว]" : "[ว่าง]";

        System.out.printf("ที่นั่ง %s%02d | "
                + "ประเภท: %s | "
                + "ราคา: %,.2f บาท | "
                + "สิทธิพิเศษ: %s %s%n",
                row,
                number,
                name,
                price,
                privilege,
                status
        );
    }

    public String getName() {
        return name;
    }

    public String getPrivilege() {
        return privilege;
    }

    public double getPrice() {
        return price;
    }
}
