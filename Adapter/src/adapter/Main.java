package adapter;

import models.ImportedFrameCatalog;
import models.ThaiShopOrder;
import services.BaseFrameAdapter;
import services.ImportedFrameAdapter;
import services.ThaiFrameAdapter;

public class Main {

    // เมธอดแสดงสเปกและราคาผ่าน Adapter กลาง
    public static void client(int units, double budget) {
        // 1. สเปกช่างไทย (1000 x 2000 mm)
        BaseFrameAdapter thaiFrame = new ThaiFrameAdapter(new ThaiShopOrder(1000.0, 2000.0));

        // 2. สเปกนำเข้า (36 x 80 นิ้ว, หนัก 25 ปอนด์)
        BaseFrameAdapter importFrame = new ImportedFrameAdapter(new ImportedFrameCatalog(36.0, 80.0, 25.0));

        System.out.println("=== ประเมินราคาติดตั้งหน้าต่างบ้าน (" + units + " บาน | งบ " + budget + " บาท) ===");
        System.out.println();

        // 1. แสดงสเปกและราคาฝั่งช่างไทย
        double thaiTotal = thaiFrame.getPrice() * units;
        System.out.println("[1. สั่งผลิตช่างไทย]");
        
        System.out.printf(
                "\t- พื้นที่กระจก: %.2f Sq.Ft. | น้ำหนักเฟรม: %.2f kg.%n",
                thaiFrame.getGlassSqFt(), thaiFrame.getAluminumWeightKg()
        );
        
        System.out.printf(
                "\t- ราคา/บาน: %,.2f บาท | รวม %d บาน: %,.2f บาท%n%n",
                thaiFrame.getPrice(), units, thaiTotal
        );

        // 2. แสดงสเปกและราคาฝั่งนำเข้า
        double importTotal = importFrame.getPrice() * units;
        
        System.out.println("[2. สินค้านำเข้าสำเร็จรูป]");
        
        System.out.printf(
                "\t- พื้นที่กระจก: %.2f Sq.Ft. | น้ำหนักเฟรม: %.2f kg.%n",
                importFrame.getGlassSqFt(), importFrame.getAluminumWeightKg()
        );
        
        System.out.printf(
                "\t- ราคา/บาน: %,.2f บาท | รวม %d บาน: %,.2f บาท%n%n",
                importFrame.getPrice(), units, importTotal
        );

        // เปรียบเทียบและสรุปผล
        System.out.println("----------------------------------------");
        
        if (thaiTotal < importTotal) {
            System.out.printf("สรุป: เลือก [ สั่งช่างไทย ] คุ้มกว่า (ประหยัดไป %,.2f บาท)%n", importTotal - thaiTotal);
        } else {
            System.out.printf("สรุป: เลือก [ สั่งนำเข้า ] คุ้มกว่า (ประหยัดไป %,.2f บาท)%n", thaiTotal - importTotal);
        }
    }

    public static void main(String[] args) {
        int units = 10;          // โจทย์: ติดตั้งหน้าต่างบ้าน 10 บาน
        double budget = 50000.0; // งบประมาณ 50,000 บาท

        client(units, budget);
    }
}