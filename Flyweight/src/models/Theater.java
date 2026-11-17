/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author macbook
 */
public class Theater {

    private String name;
    private List<Seat> seats;

    public Theater(String name) {
        this.name = name;
        this.seats = new ArrayList<>();
    }

    public void addSeat(String row, int number, String typeName, double price, String privilege, SeatFactory factory) {
        SeatType type = factory.getSeatType(typeName, price, privilege);
        
        if (type == null) {
            System.out.printf("ไม่พบประเภทที่นั่ง '%s' ในระบบ กรุณาลงทะเบียนผ่าน Factory ก่อน%n", typeName);
            
            return;
        }
        
        seats.add(new Seat(row, number, type));
    }

    public boolean bookSeat(String row, int number) {
        for (Seat seat : seats) {
            if (seat.getRow().equalsIgnoreCase(row) && seat.getNumber() == number) {
                seat.book();
                
                return true;
            }
        }
        
        return false;
    }

    public void displayLayout() {
        System.out.println("================================================================================");
        System.out.printf("ผังที่นั่งโรงภาพยนตร์: %s (ทั้งหมด %d ที่นั่ง)%n", name, seats.size());
        System.out.println("================================================================================");
        
        for (Seat seat : seats) {
            seat.displaySeat();
        }
    }

    public int getTotalSeats() {
        return seats.size();
    }
}
