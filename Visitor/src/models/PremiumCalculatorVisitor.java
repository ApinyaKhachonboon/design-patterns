/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import interfaces.InsuranceVisitor;

/**
 *
 * @author macbook
 */
public class PremiumCalculatorVisitor implements InsuranceVisitor {

    private double totalPremium = 0.0;

    @Override
    public void visit(CarAsset car) {
        double basePremium = (car.getEngineCc() > 2000) ? 18000.0 : 12000.0;
        double claimSurcharge = car.getClaimHistory() * 2500.0;
        double finalPremium = basePremium + claimSurcharge;
        
        totalPremium += finalPremium;

        System.out.printf(
                "[คำนวณเบี้ย - รถยนต์ %s] ขนาด %d CC, เคลม %d ครั้ง -> เบี้ยประกัน: %,.2f บาท/ปี%n",
                car.getLicensePlate(), 
                car.getEngineCc(), 
                car.getClaimHistory(), 
                finalPremium
        );
    }

    @Override
    public void visit(HouseAsset house) {
        double basePremium = house.getAreaSqm() * 35.0;
        double floodSurcharge = house.isFloodZone() ? 4500.0 : 0.0;
        double finalPremium = basePremium + floodSurcharge;
        
        totalPremium += finalPremium;

        System.out.printf(
                "[คำนวณเบี้ย - บ้านพัก %s] พื้นที่ %.1f ตร.ม., โซนน้ำท่วม: %s -> เบี้ยประกัน: %,.2f บาท/ปี%n",
                house.getAddress(), 
                house.getAreaSqm(), 
                (house.isFloodZone() ? "ใช่" : "ไม่ใช่"), 
                finalPremium
        );
    }

    @Override
    public void visit(FactoryAsset factory) {
        double basePremium = factory.getMachineValue() * 0.015; // 1.5% ของมูลค่าเครื่องจักร
        double hazardMultiplier = 1.0 + (factory.getHazardLevel() * 0.20);
        double finalPremium = basePremium * hazardMultiplier;
        
        totalPremium += finalPremium;

        System.out.printf(
                "[คำนวณเบี้ย - โรงงาน %s] เครื่องจักร %,.0f บาท, ความเสี่ยงระดับ %d -> เบี้ยประกัน: %,.2f บาท/ปี%n",
                factory.getFactoryName(), 
                factory.getMachineValue(), 
                factory.getHazardLevel(), 
                finalPremium
        );
    }

    public double getTotalPremium() {
        return totalPremium;
    }
}
