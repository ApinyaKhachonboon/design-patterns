/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.proxy;

import dtos.PromptPayData;
import dtos.SlipResult;
import interfaces.ISlipVerificationService;

/**
 *
 * @author macbook
 */
public class PreFilterSlipProxy implements ISlipVerificationService {

    private ISlipVerificationService realService;

    public PreFilterSlipProxy(ISlipVerificationService realService) {
        this.realService = realService;
    }

    @Override
    public SlipResult verifySlip(byte[] imageBuffer) {
        // สแกนหา PromptPay QR ในระดับ Local
        PromptPayData qrData = scanPromptPayQr(imageBuffer);
        
        if (qrData == null) {
            return SlipResult.failed("Reject: ไม่พบ QR Code สลิปธนาคาร (รูปภาพทั่วไป/รูปการ์ตูน)");
        }

        // ตรวจสอบ TransRef ซ้ำกับ Mock Database
        if (isDuplicate(qrData.getTransRef())) {
            return SlipResult.failed("Reject: สลิปนี้ถูกใช้งานไปแล้ว (Duplicate TransRef: " + qrData.getTransRef() + ")");
        }

        return this.realService.verifySlip(imageBuffer);
    }

    private PromptPayData scanPromptPayQr(byte[] imageBuffer) {
        if (imageBuffer == null || imageBuffer.length == 0) {
            return null;
        }

        // Mock: จำลองผลลัพธ์จากการสแกนและถอดรหัส TLV
        String mockPayload = "00390006000001010301102182608212038171310545102TH91042C00";
        
        return new PromptPayData("011", "260821203817131054", mockPayload);
    }

    private boolean isDuplicate(String transRef) {
        // Mock: เช็คข้อมูลที่เคยบันทึกไว้ในระบบ
        String[] mockUsedRefs = {"999888777666555444", "111222333444555666", "260821203817131054"};
        
        for (String usedRef : mockUsedRefs) {
            if (usedRef.equals(transRef)) {
                return true;
            }
        }
        
        return false;
    }
}
