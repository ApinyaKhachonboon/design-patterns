/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package composite;

import interfaces.MenuItem;
import models.ComboSet;
import models.Dish;

public class Main {

    public static void client() {
        // อาหารจานเดี่ยว (Leaf)
        MenuItem ribeye = new Dish("Ribeye Steak", 650.0, 850);
        MenuItem wine = new Dish("Red Wine Glass", 180.0, 120);
        MenuItem carbonara = new Dish("Truffle Carbonara", 320.0, 680);
        MenuItem garlicBread = new Dish("Garlic Bread", 120.0, 310);
        MenuItem tiramisu = new Dish("Tiramisu", 180.0, 360);
        MenuItem aCleare = new Dish("เอแคลร์", 90.0, 250);

        // เซ็ตย่อย (Composite ชั้นใน)
        ComboSet pastaSideSet = new ComboSet("Pasta & Side Set");
        pastaSideSet.add(carbonara);
        pastaSideSet.add(garlicBread);
        
        
        ComboSet sweetSet = new ComboSet("sweet Set");
        sweetSet.add(tiramisu);
        sweetSet.add(aCleare);
        
        pastaSideSet.add(sweetSet);

        // เซ็ตใหญ่ (Root Composite ที่มีทั้ง Leaf และ Composite ย่อย)
        ComboSet grandDinner = new ComboSet("Grand Italian-Steak Dinner");
        grandDinner.add(ribeye);
        grandDinner.add(wine);
        grandDinner.add(pastaSideSet);

        // แสดงผลลัพธ์โครงสร้าง Tree
        grandDinner.printTree("");

        // เรียกคำนวณราคารวมและแคลอรีรวมจาก Root ตัวเดียว
        System.out.println("\n-------------------------------------------");
        System.out.println("Final Bill: " + grandDinner.getPrice() + " THB");
        System.out.println("Total Energy: " + grandDinner.getCalories() + " kcal");
    }

    public static void main(String[] args) {
        client();
    }
}
