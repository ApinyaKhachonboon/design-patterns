/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package chain_of_responsibility;

import handlers.BulkPurchaseDiscountHandler;
import handlers.CouponCodeDiscountHandler;
import handlers.FreeShippingHandler;
import handlers.MemberTierDiscountHandler;
import interfaces.Handler;
import java.util.Map;
import models.Order;

/**
 *
 * @author macbook
 */
public class Main {

    public static void client(Order order) {
        // สร้าง Handlers แต่ละด่าน
        Handler memberHandler = new MemberTierDiscountHandler();
        Handler couponHandler = new CouponCodeDiscountHandler(Map.of(
                "SAVE100", 100.0, 
                "SAVE200", 200.0,
                "SAVE500", 500.0,
                "SAVE1000", 1000.0
        ));
        Handler bulkHandler = new BulkPurchaseDiscountHandler(10, 0.02); // 10 ชิ้นขึ้นไป ลด 2%
        Handler shippingHandler = new FreeShippingHandler(500.0); // ยอด 500 ขึ้นไป ส่งฟรี

        // Chain handler ต่อเนื่อง
        memberHandler.setNext(couponHandler).setNext(bulkHandler).setNext(shippingHandler);
        
        memberHandler.handle(order);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Order: ลูกค้า Gold, มีคูปอง SAVE100, ซื้อ 12 ชิ้น, ยอดรวม 1,000 บาท
        Order order = new Order("ORD-2026-001", "GOLD", "SAVE100", 12, 1000.0);

        System.out.println("==================================================");
        System.out.println("เริ่มกระบวนการคำนวณส่วนลดสำหรับคำสั่งซื้อ: " + order.getOrderId());
        System.out.printf("ยอดเริ่มต้นก่อนหักส่วนลด: %,.2f บาท%n", order.getSubtotal());
        System.out.println("--------------------------------------------------");

        // ส่ง Order เข้าจุดเริ่มต้นของ Chain
        client(order);

        // สรุปผลลัพธ์สุดท้าย
        System.out.println("--------------------------------------------------");
        System.out.printf("ส่วนลดรวมทั้งหมด: -%,.2f บาท%n", order.getTotalDiscount());
        System.out.printf("ค่าจัดส่ง: %,.2f บาท%n", order.getShippingFee());
        System.out.printf("ยอดสุทธิที่ต้องชำระ: %,.2f บาท%n", order.getNetTotal());
        System.out.println("==================================================");
    }

}
