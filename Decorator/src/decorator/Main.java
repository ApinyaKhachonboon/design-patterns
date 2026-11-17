/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package decorator;

import interfaces.SaleDocument;
import models.DiscountDecorator;
import models.Quotation;
import models.SecurityInfoDecorator;
import models.UrgentDecorator;
import models.VatDecorator;
import models.WatermarkDecorator;

/**
 *
 * @author macbook
 */
public class Main {

    public static SaleDocument client(SaleDocument qt) {
        // Decorate ชั้นที่ 1: ส่วนลด VIP 10%
        SaleDocument qtWithDiscount = new DiscountDecorator(qt, 0.10, "VIP_CORPORATE_DISCOUNT");

        // Decorate ชั้นที่ 2: ค่าบริการส่งด่วน 24 ชม. (+2,000 บาท)
        SaleDocument qtWithDiscountWithUrgent = new UrgentDecorator(qtWithDiscount, 2000.0, 1);

        // Decorate ชั้นที่ 3: คิด VAT 7% รวมภาษี
        SaleDocument qtWithDiscountWithUrgentWithVat = new VatDecorator(
                qtWithDiscountWithUrgent, 
                0.07, 
                "0-1055-69999-88-1", 
                true, 
                "00000"
        );

        // Decorate ชั้นที่ 4: แปะลายน้ำ
        SaleDocument qtWithDiscountWithUrgentWithVatWithWatermark = new WatermarkDecorator(
                qtWithDiscountWithUrgentWithVat,
                "MY_COMPANY",
                0.4
        );

        // Decorate ชั้นที่ 5: Mask เฉพาะเบอร์โทรศัพท์และอีเมล
        SaleDocument qtWithDiscountWithUrgentWithVatWithSecurityInfo = new SecurityInfoDecorator(
                qtWithDiscountWithUrgentWithVatWithWatermark,
                true,
                true
        );

        return qtWithDiscountWithUrgentWithVatWithSecurityInfo;
    }

    public static void main(String[] args) {

        // 1. สร้าง Quotation (QT)
        SaleDocument qt = new Quotation(
                "QT-2026-08001",
                "บริษัท โลจิสติกส์ ไทยจำกัด",
                "081-234-5678",
                "somchai@example.com",
                "19-08-2026",
                100000.0
        );

        SaleDocument wrappedQt = client(qt);

        // 6. แสดงผลเอกสาร
        System.out.println(wrappedQt.render());
        
        System.out.println("=================================================================");
        System.out.printf("ยอดเงินสุทธิที่ต้องชำระ (Final Total Amount) : %,.2f บาท%n", wrappedQt.getFinalPrice());
        System.out.println("=================================================================");
    }
}
