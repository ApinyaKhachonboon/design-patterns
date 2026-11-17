/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package observer;

import models.OfficeStaff;
import models.Person;
import models.Resident;
import publishers.AnnouncementPublisher;

/**
 *
 * @author macbook
 */
public class Main {

    public static void client() {
        // 1. สร้าง Publisher
        AnnouncementPublisher publicPublisher = new AnnouncementPublisher("ส่วนกลาง");
        AnnouncementPublisher staffPublisher = new AnnouncementPublisher("ภายในแจ้งพนักงาน");

        // 2. สร้าง Observer
        Person resident1 = new Resident("101", "สมชาย", "somchai@email.com", "081-111-2222");
        Person resident2 = new Resident("102", "สมหญิง", "somying@email.com", "089-222-3333");
        Person techStaff = new OfficeStaff("สมบัติ", "ช่างอาคาร", "tech@dorm.com", "084-555-6666");
        Person manager = new OfficeStaff("วิภา", "ผู้จัดการ", "manager@dorm.com", "087-888-9999");

        // 3. กำหนดสิทธิ์การรับข่าวสาร
        // ประกาศสาธารณะ: ลูกบ้าน + พนักงาน
        publicPublisher.subscribe(resident1);
        publicPublisher.subscribe(resident2);
        publicPublisher.subscribe(techStaff);

        // ประกาศภายใน: เฉพาะพนักงาน
        staffPublisher.subscribe(techStaff);
        staffPublisher.subscribe(manager);

        // 4. ทดสอบยิงข้อความ
        System.out.println("=== ยิงประกาศส่วนกลาง ===");
        publicPublisher.setMessage("ประกาศซ่อมท่อประปา: น้ำจะไม่ไหลวันที่ 5 เวลา 10:00 - 12:00 น.");

        System.out.println("\n=== ยิงประกาศภายในพนักงาน ===");
        staffPublisher.setMessage("เวรตรวจมิเตอร์น้ำ: ให้ช่างเข้าตรวจพร้อมเตรียมอุปกรณ์ช่วง 13:00 น.");

        System.out.println("=== ยิงประกาศส่วนกลาง ===");
        publicPublisher.setMessage("ประกาศสาย internet: เน็ตจะใช้ไม่ได้ในวันที่ 10 เวลา 13:00 - 16:00 น.");
    }

    public static void main(String[] args) {
        client();
    }
}
