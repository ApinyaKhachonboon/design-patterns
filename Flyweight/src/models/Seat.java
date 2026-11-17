/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author macbook
 */
public class Seat {

    private String row;
    private int number;
    private SeatType type;
    private boolean isBooked;

    public Seat(String row, int number, SeatType type) {
        this.row = row;
        this.number = number;
        this.type = type;
        this.isBooked = false;
    }

    public void book() {
        this.isBooked = true;
    }

    public void displaySeat() {
        type.displaySeat(row, number, isBooked);
    }

    public boolean isIsBooked() {
        return isBooked;
    }

    public void setIsBooked(boolean isBooked) {
        this.isBooked = isBooked;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public SeatType getType() {
        return type;
    }

    public void setType(SeatType type) {
        this.type = type;
    }
}
