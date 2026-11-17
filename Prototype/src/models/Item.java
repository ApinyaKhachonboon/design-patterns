/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author macbook
 */
public class Item {

    private String name;
    private double price;
    private int amount;

    public Item(Item target) {
        if (target != null) {
            this.name = target.name;
            this.price = target.price;
            this.amount = target.amount;
        }
    }

    public Item(String name, double price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public Item copy() {
        return new Item(this);
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return name + " (Qty: " + amount + ", Price: " + price + ")";
    }
}
