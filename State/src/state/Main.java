/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package state;

import models.Cloud;
import models.CloudForming;

/**
 *
 * @author macbook
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // จำลองสภาพอากาศเขตร้อน: อุณหภูมิ 34°C, เมฆลอยต่ำที่ 1200 เมตร
        double thailandTemp = 34.0;
        double cloudAltitude = 1200.0;

        System.out.println("=== เริ่มจำลองเมฆฝน สภาพอากาศประเทศไทย (34°C / เมฆลอยต่ำ 1200m) ===");
        Cloud monsoonCloud = new Cloud(new CloudForming(), cloudAltitude, thailandTemp);

        // --- เคส 1: เมฆยังบาง สะสมไอน้ำและลองเรียกฝนตก ---
        System.out.println("\n--- [เฟส 1: เริ่มก่อตัว (Forming)] ---");
        monsoonCloud.dropRain();         // ยังไม่ตก
        monsoonCloud.addMoisture(35.0);  // สะสมไอน้ำ
        monsoonCloud.addMoisture(45.0);  // ความชื้นเกินเกณฑ์ -> เข้า Overcast อัตโนมัติ

        // --- เคส 2: มืดครึ้ม เพิ่มไอน้ำได้ และสั่งให้ฝนตก ---
        System.out.println("\n--- [เฟส 2: เมฆดำทะมึน (Overcast)] ---");
        monsoonCloud.addMoisture(20.0);  // เมฆหนาขึ้นอีก
        monsoonCloud.dropRain();         // เริ่มปล่อยฝน -> เข้าสู่ Raining

        // --- เคส 3: ฝนกำลังตกหนัก ลองเพิ่มไอน้ำ (ทำไม่ได้) แล้วตกจนฝนซา ---
        System.out.println("\n--- [เฟส 3: ฝนตกหนัก (Raining)] ---");
        monsoonCloud.addMoisture(15.0);  // Raining ปฏิเสธการรับความชื้น
        monsoonCloud.dropRain();         // ฝนเทรอบแรก (ลด 35%)
        monsoonCloud.dropRain();         // ความชื้นลดต่ำ <= 30% -> ย้อนกลับเป็น Overcast

        // --- เคส 4: ฝนซากลับเป็น Overcast แล้วสะสมน้ำเพิ่มเพื่อเทซ้ำจนหมด ---
        System.out.println("\n--- [เฟส 4: ฝนซาแต่กลับมาตกซ้ำจนหมดก้อน] ---");
        monsoonCloud.addMoisture(25.0);  // เติมน้ำกลับเข้าไปใน Overcast
        monsoonCloud.dropRain();         // สั่งฝนตกอีกรอบ -> กลับเข้า Raining
        monsoonCloud.dropRain();         // ตกจนความชื้นเหลือ 0% -> สลายตัวกลับเป็น Forming

        // --- เคส 5: ฟ้าหลังฝน เคลียร์สภาพอากาศ ---
        System.out.println("\n--- [เฟส 5: จบวัฏจักร] ---");
        monsoonCloud.clearUp();
    }

}
