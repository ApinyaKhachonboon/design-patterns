/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mediator;

import models.Customer;
import models.DeliveryStaff;
import models.FinanceOfficer;
import models.SalesPerson;
import models.ServiceAdvisor;
import models.ShowroomMediator;

/**
 *
 * @author macbook
 */
public class Main {
    public static void main(String[] args) {
        // 1. สร้างตัวละคร (Colleagues) ทั้งหมดขึ้นมา
        Customer customer = new Customer("คุณสมชาย", "081-234-5678", 1500000.0);
        SalesPerson sales = new SalesPerson("คุณสมศรี", 0.05);
        FinanceOfficer finance = new FinanceOfficer("คุณวิชัย", 700);
        ServiceAdvisor service = new ServiceAdvisor("คุณช่างกล้า", "Bay-01");
        DeliveryStaff delivery = new DeliveryStaff("คุณไมตรี", "Delivery-Zone");

        // 2. สร้าง Mediator และผูกความสัมพันธ์อัตโนมัติ
        ShowroomMediator mediator = new ShowroomMediator(customer, sales, finance, service, delivery);

        System.out.println("=== เริ่มต้นจำลองสถานการณ์ในโชว์รูมรถยนต์ (End-to-End Workflow) ===\n");

        // --- เฟสที่ 1: ลูกค้าขอทดลองขับ ---
        customer.requestTestDrive();

        System.out.println("\n--------------------------------------------------");

        // --- เฟสที่ 2: ลูกค้าตัดสินใจซื้อรถและทำใบเสนอราคา ---
        customer.buyCar();

        System.out.println("\n--------------------------------------------------");

        // --- เฟสที่ 3: ไฟแนนซ์อนุมัติสินเชื่อ ---
        finance.approveLoan();

        System.out.println("\n--------------------------------------------------");

        // --- เฟสที่ 4: รถพร้อมและลูกค้าเซ็นสัญญา ---

        System.out.println("\n=== สิ้นสุดกระบวนการส่งมอบรถสมบูรณ์แบบ ===");
    }
}
