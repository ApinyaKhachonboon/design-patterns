/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import interfaces.MenuItem;

/**
 *
 * @author macbook
 */
public class Dish implements MenuItem {

    private String name;
    private double price;
    private int calories;

    public Dish(String name, double price, int calories) {
        this.name = name;
        this.price = price;
        this.calories = calories;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public int getCalories() {
        return calories;
    }

    @Override
    public void printTree(String indent) {
        System.out.println(indent + "- [Dish] " + name + " (" + price + " THB, " + calories + " kcal)");
    }
}
