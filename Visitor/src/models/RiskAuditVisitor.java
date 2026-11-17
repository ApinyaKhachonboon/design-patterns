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
public class RiskAuditVisitor implements InsuranceVisitor {

    @Override
    public void visit(CarAsset car) {
        String riskStatus;
        
        if (car.getClaimHistory() >= 3) {
            riskStatus = "ความเสี่ยงสูง (ต้องกำหนดค่าเสียหายส่วนแรก Deductible 5,000 บาท)";
        } else if (car.getEngineCc() > 2500) {
            riskStatus = "ความเสี่ยงปานกลาง (ต้องติดกล้องหน้ารถก่อนอนุมัติ)";
        } else {
            riskStatus = "ความเสี่ยงต่ำ (อนุมัติกรมธรรม์ได้ทันที)";
        }
        
        System.out.printf(
                "[ประเมินความเสี่ยง - รถยนต์ %s] ผลตรวจ: %s%n",
                car.getLicensePlate(), 
                riskStatus
        );
    }

    @Override
    public void visit(HouseAsset house) {
        String riskStatus;
        
        if (house.isFloodZone() && house.getAreaSqm() > 300) {
            riskStatus = "ความเสี่ยงสูง (ต้องส่งเจ้าหน้าที่สำรวจแนวป้องกันน้ำท่วมก่อนรับประกัน)";
        } else if (house.isFloodZone()) {
            riskStatus = "ความเสี่ยงปานกลาง (จำกัดวงเงินคุ้มครองน้ำท่วมไม่เกิน 100,000 บาท)";
        } else {
            riskStatus = "ความเสี่ยงต่ำ (อนุมัติความคุ้มครองอัคคีภัยและภัยธรรมชาติเต็มวงเงิน)";
        }
        
        System.out.printf(
                "[ประเมินความเสี่ยง - บ้านพัก %s] ผลตรวจ: %s%n",
                house.getAddress(), 
                riskStatus
        );
    }

    @Override
    public void visit(FactoryAsset factory) {
        String riskStatus;
        
        if (factory.getHazardLevel() >= 4) {
            riskStatus = "ความเสี่ยงสูงมาก (บังคับตรวจระบบดับเพลิงอัตโนมัติทุก 6 เดือน)";
        } else if (factory.getMachineValue() > 10000000) {
            riskStatus = "ความเสี่ยงปานกลาง (ต้องทำประกันภัยต่อ Reinsurance ร่วมด้วย ป้องกันการล้มละลาย)";
        } else {
            riskStatus = "ความเสี่ยงต่ำ (ผ่านเกณฑ์มาตรฐานโรงงานอุตสาหกรรม)";
        }
        
        System.out.printf(
                "[ประเมินความเสี่ยง - โรงงาน %s] ผลตรวจ: %s%n",
                factory.getFactoryName(), 
                riskStatus
        );
    }
}
