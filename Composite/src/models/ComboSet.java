/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import interfaces.MenuItem;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author macbook
 */
public class ComboSet implements MenuItem {

    private String name;
    private List<MenuItem> items;

    public ComboSet(String name) {
        this.name = name;
        this.items = new ArrayList<>();
    }

    public void add(MenuItem item) {
        items.add(item);
    }

    public void remove(MenuItem item) {
        items.remove(item);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        double total = 0;
        
        for (MenuItem item : items) {
            total += item.getPrice();
        }
        
        return total;
    }

    @Override
    public int getCalories() {
        int total = 0;
        
        for (MenuItem item : items) {
            total += item.getCalories();
        }
        
        return total;
    }

    @Override
    public void printTree(String indent) {
        System.out.println(indent + "+ [Set] "
                + name + " (Total: " + getPrice() + " THB, "
                + getCalories() + " kcal)");

        for (MenuItem item : items) {
            item.printTree(indent + "\t");
        }
    }
}
