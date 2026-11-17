/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package visitor;

import interfaces.InsuranceVisitor;
import interfaces.InsuredElement;
import java.util.Arrays;
import java.util.List;
import models.CarAsset;
import models.FactoryAsset;
import models.HouseAsset;
import models.PremiumCalculatorVisitor;
import models.RiskAuditVisitor;

/**
 *
 * @author macbook
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // 1. เตรียมรายการทรัพย์สินของลูกค้า
        List<InsuredElement> portfolio = Arrays.asList(
                new CarAsset("กข-1234 กรุงเทพฯ", 1800, 1),
                new HouseAsset("บ้านเดี่ยว นนทบุรี (120/5)", 220, true),
                new FactoryAsset("โรงงานแปรรูปอาหาร สมุทรปราการ", 5000000, 4)
        );

        System.out.println("=== รอบที่ 1: คำนวณเบี้ยประกันรายปี ===");
        
        PremiumCalculatorVisitor c1 = new PremiumCalculatorVisitor();
        
        for (InsuredElement element : portfolio) {
            element.accept(c1);
        }
        
        System.out.printf(">> รวมเบี้ยประกันทั้งพอร์ตโฟลิโอ: %,.2f บาท/ปี%n%n", c1.getTotalPremium());

        System.out.println("=== รอบที่ 2: ตรวจสอบและประเมินความเสี่ยง ===");
        
        InsuranceVisitor c2 = new RiskAuditVisitor();
        
        for (InsuredElement element : portfolio) {
            element.accept(c2);
        }
    }

}
