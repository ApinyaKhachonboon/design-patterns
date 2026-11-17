/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import interfaces.Mediator;

/**
 *
 * @author macbook
 */

public class ShowroomMediator implements Mediator {
    private Customer customer;
    private SalesPerson sales;
    private FinanceOfficer finance;
    private ServiceAdvisor service;
    private DeliveryStaff delivery;

    public ShowroomMediator(
            Customer customer, 
            SalesPerson sales,
            FinanceOfficer finance, 
            ServiceAdvisor service, 
            DeliveryStaff delivery
    ) {
        this.customer = customer;
        this.sales = sales;
        this.finance = finance;
        this.service = service;
        this.delivery = delivery;

        // ผูก Mediator ให้กับทุก Colleague อัตโนมัติ
        this.customer.setMediator(this);
        this.sales.setMediator(this);
        this.finance.setMediator(this);
        this.service.setMediator(this);
        this.delivery.setMediator(this);
    }

    @Override
    public void notify(ShowroomColleague sender, String msg) {
        // 1. เมื่อลูกค้าขอทดลองขับ -> ฝ่ายขายพาชมรถ & ฝ่ายบริการตรวจสภาพรถ
        if (sender == customer && msg.equals("request_test_drive")) {
            System.out.println("\n--- [Workflow: สถานการณ์ทดลองขับ] ---");
            
            sales.accompanyCustomer();
            service.inspectVehicle();
        } 
        // 2. เมื่อลูกค้าตกลงซื้อรถ -> ฝ่ายขายทำใบเสนอราคา & การเงินตรวจเครดิต
        else if (sender == customer && msg.equals("buy_car")) {
            System.out.println("\n--- [Workflow: ขั้นตอนการสั่งซื้อและตรวจสอบสินเชื่อ] ---");
            
            sales.createQuotation();
            finance.checkCreditBureau();
        }
        
        // 3. เมื่อฝ่ายขายทำใบเสนอราคาเสร็จ -> การเงินคำนวณค่างวดต่อทันที
        else if (sender == sales && msg.equals("quotation_ready")) {
            finance.calculateInstallment();
        }

        // 4. เมื่อการเงินคำนวณค่างวดเสร็จ (และจำลองว่าอนุมัติผ่าน) -> จำลองให้กดอนุมัติสินเชื่อ
        // (หรือถ้าโครงสร้างจริง ไฟแนนซ์จะเรียก approveLoan() ต่อ)
        
        // 5. เมื่อไฟแนนซ์อนุมัติสินเชื่อสำเร็จ -> ฝ่ายบริการทำการติดตั้งอุปกรณ์/ตกแต่งรถ และเตรียมรถ
        else if (sender == finance && msg.equals("finance_approved")) {
            System.out.println("\n--- [Workflow: ไฟแนนซ์อนุมัติ - ดำเนินการเตรียมรถ] ---");
            
            service.installAccessories();
            service.prepareDeliveryDoc();
        }

        // 6. เมื่อฝ่ายบริการเตรียมรถเสร็จ -> พนักงานขายนัดหมาย และลูกค้าเซ็นสัญญา
        else if (sender == service && msg.equals("vehicle_ready")) {
            System.out.println("\n--- [Workflow: รถพร้อม - นัดหมายและเซ็นสัญญา] ---");
            
            customer.signContract();
        }

        // 7. เมื่อลูกค้าเซ็นสัญญาเสร็จ -> เข้าสู่กระบวนการส่งมอบจริงในวันรับรถ
        else if (sender == customer && msg.equals("contract_signed")) {
            System.out.println("\n--- [Workflow: วันส่งมอบรถจริง] ---");
            
            delivery.handoverKey();
            sales.explainCarFeatures();
            delivery.explainManual();
            customer.receiveKey();
            delivery.completeDelivery(); // ส่งสัญญาณปิดจบเคส
        }

        // 8. เมื่อกระบวนการส่งมอบทั้งหมดเสร็จสิ้น
        else if (sender == delivery && msg.equals("delivery_completed")) {
            System.out.println("\n--- [Workflow: จบกระบวนการซื้อขายและส่งมอบสมบูรณ์แบบ] ---");
        }
    }
}
