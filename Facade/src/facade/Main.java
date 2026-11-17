/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package facade;

import dtos.PartyBookingRequest;
import dtos.PartyBookingResult;
import java.util.Date;
import utils.PartyOrganizerFacade;

/**
 *
 * @author macbook
 */
public class Main {

    public static void client() {
        // 1. Client เตรียมข้อมูลตัวเลือกผ่าน DTO
        PartyBookingRequest request = new PartyBookingRequest(
                "งานเลี้ยงสังสรรค์ประจำปี บริษัท สยามเทค จำกัด",
                new Date(),
                150,
                200000.00,
                "ลูกทุ่งพรีเมียม งานวัดไฮโซ",
                "ห้องแกรนด์บอลรูม โรงแรมแมริออท",
                200,
                45000.00,
                "บุฟเฟต์อาหารไทย-นานาชาติ + ซอฟต์ดริ้งก์",
                true,
                550.00,
                8000,
                "จ๊ะอาร์สยาม",
                25000.00,
                "คุณตาปัญญา"
        );

        // 2. สร้าง Facade โดยส่ง request เข้าไปเตรียม Subsystems ใน Constructor
        PartyOrganizerFacade organizer = new PartyOrganizerFacade(request);

        // 3. สั่งรันขั้นตอนการจอง
        PartyBookingResult result = organizer.organizeParty();

        // 4. พิมพ์สรุปผลลัพธ์
        System.out.println("\n" + result.getSummary());
    }

    public static void main(String[] args) {
        client();
    }

}
