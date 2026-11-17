/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package command;

import interfaces.OrderChannelInvoker;
import invokers.DeliveryGatewayInvoker;
import invokers.PosCounterInvoker;
import invokers.QrOrderingInvoker;
import models.MenuItem;
import models.Order;
import models.OrderDetail;
import receivers.CashierService;
import receivers.KitchenService;

/**
 *
 * @author macbook
 */
public class Main {

    public static void client() {
        // เตรียมข้อมูลเมนูอาหาร
        MenuItem basilBeef = new MenuItem("ข้าวกะเพราเนื้อไข่ดาว", 85.0);
        MenuItem thaiTea = new MenuItem("ชาไทยเย็นหวานน้อย", 45.0);
        MenuItem friedPork = new MenuItem("หมูกรอบทอดน้ำปลา", 120.0);
        MenuItem greenCurry = new MenuItem("แกงเขียวหวานไก่", 90.0);

        // สร้าง Services (Receivers)
        KitchenService kitchen = new KitchenService();
        CashierService cashier = new CashierService(kitchen);

        // สร้าง Invokers สำหรับแต่ละช่องทาง
        OrderChannelInvoker qrChannel = new QrOrderingInvoker();
        OrderChannelInvoker posChannel = new PosCounterInvoker();
        OrderChannelInvoker deliveryChannel = new DeliveryGatewayInvoker();

        System.out.println("=== 1. ลูกค้าสแกน QR Code (โต๊ะ T-05) ===");
        Order orderQR = new Order("ORD-001", "T-05");
        OrderDetail teaDetail = new OrderDetail(thaiTea, 2);
        orderQR.addDetail(new OrderDetail(basilBeef, 1));
        orderQR.addDetail(teaDetail);

        // ส่งเข้าครัวผ่านช่องทาง QR
        qrChannel.setCommand(new PlaceOrderCommand(kitchen, orderQR));
        qrChannel.executeCommand();

        System.out.println("\n=== 2. สั่งผ่าน POS Counter (โต๊ะ T-05 สั่งเพิ่ม) ===");
        Order orderPOS = new Order("ORD-002", "T-05");
        OrderDetail porkDetail = new OrderDetail(friedPork, 1);
        orderPOS.addDetail(porkDetail);

        posChannel.setCommand(new PlaceOrderCommand(kitchen, orderPOS));
        posChannel.executeCommand();

        // ทดสอบพยายามยกเลิกหลังจากเข้าครัวแล้ว (สถานะกลายเป็น SERVED แล้ว ระบบจะปฏิเสธ)
        posChannel.setCommand(new CancelOrderDetailCommand(kitchen, porkDetail, "ขอยกเลิกหมูกรอบ"));
        posChannel.executeCommand();

        System.out.println("\n=== 3. ออเดอร์จาก Delivery (Lineman / Grab) ===");
        // สำหรับเดลิเวอรี่ สามารถกำหนดเลขอ้างอิงเป็นเลขไรเดอร์หรือรหัสออเดอร์แทนโต๊ะได้ เช่น "DELI-01"
        Order orderDelivery = new Order("ORD-003", "DELI-01");
        orderDelivery.addDetail(new OrderDetail(greenCurry, 2));
        orderDelivery.addDetail(new OrderDetail(thaiTea, 1));

        deliveryChannel.setCommand(new PlaceOrderCommand(kitchen, orderDelivery));
        deliveryChannel.executeCommand();

        System.out.println("\n=== 4. เช็คบิลโต๊ะ T-05 และ ออเดอร์เดลิเวอรี่ ===");
        cashier.generateBill("T-05");
        cashier.generateBill("DELI-01");
    }

    public static void main(String[] args) {
        client();
    }
}
