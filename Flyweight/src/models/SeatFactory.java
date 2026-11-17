/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author macbook
 */
public class SeatFactory {

    private static Map<String, SeatType> seatTypes = new HashMap<>();

    public SeatType getSeatType(String name, double price, String privilege) {
        SeatType result = seatTypes.get(name);
        
        if (result == null) {
            result = new SeatType(name, price, privilege);
            
            seatTypes.put(name, result);
            
            System.out.println(">> [Factory] สร้าง Flyweight ชนิดใหม่: " + name);
        }
        
        return result;
    }
}
