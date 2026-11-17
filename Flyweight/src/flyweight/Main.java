/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package flyweight;

import models.SeatFactory;
import models.Theater;

/**
 *
 * @author macbook
 */
public class Main {

    public static Theater client() {
        SeatFactory factory = new SeatFactory();
        Theater theater = new Theater("SF Cinema World - Theater 1");

        // Scenario: จัดผังโรงหนังขนาด 80 ที่นั่ง (Standard 40, Premium 30, VIP 10)
        System.out.println("[Scenario] เริ่มต้นจัดผังโรงภาพยนตร์และเปิดรอบฉาย...");

        // 1. โซน Standard: แถว A-D (แถวละ 10 ที่นั่ง = 40 ที่นั่ง)
        for (char row = 'A'; row <= 'D'; row++) {
            for (int num = 1; num <= 10; num++) {
                theater.addSeat(row + "", num, "Standard", 220.0, "เครื่องดื่มแก้วเล็ก", factory);
            }
        }

        // 2. โซน Premium: แถว E-G (แถวละ 10 ที่นั่ง = 30 ที่นั่ง)
        for (char row = 'E'; row <= 'G'; row++) {
            for (int num = 1; num <= 10; num++) {
                theater.addSeat(row + "", num, "Premium", 280.0, "เบาะหนัง + ที่วางแก้วคู่", factory);
            }
        }

        // 3. โซน VIP Sofa: แถว H แถวเดียว (แถวละ 10 ที่นั่ง = 10 ที่นั่ง)
        for (int num = 1; num <= 10; num++) {
            theater.addSeat("H", num, "VIP Sofa", 600.0, "Sofa Bed + ป๊อปคอร์นฟรี + Lounge", factory);
        }

        // รายงานผล
        System.out.println("\n[สรุปข้อมูลระบบ]");
        System.out.printf("- จำนวนที่นั่งทั้งหมดในโรง : %d ที่นั่ง%n", theater.getTotalSeats());

        return theater;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Theater theater = client();

        // จำลองลูกค้าเข้ามาจองที่นั่ง
        System.out.println("[จำลองการจองตั๋ว]");

        theater.bookSeat("A", 5);  // ลูกค้า A จอง Standard A05
        theater.bookSeat("E", 1);  // ลูกค้า B จอง Premium E01
        theater.bookSeat("H", 9);  // ลูกค้า C จอง VIP Sofa H09
        theater.bookSeat("H", 10); // ลูกค้า C จอง VIP Sofa H10

        System.out.println("ทำการจองที่นั่ง A05, E01, H09, H10 เรียบร้อยแล้ว\n");

        // แสดงผังที่นั่งทั้งหมด
        theater.displayLayout();
    }

}
