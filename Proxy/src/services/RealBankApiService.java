package services;


import dtos.SlipResult;
import interfaces.ISlipVerificationService;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author macbook
 */
public class RealBankApiService implements ISlipVerificationService {

    private String apiKey;
    private String endpointUrl;

    public RealBankApiService(String apiKey, String endpointUrl) {
        this.apiKey = apiKey;
        this.endpointUrl = endpointUrl;
    }

    @Override
    public SlipResult verifySlip(byte[] imageBuffer) {
        System.out.println("[RealBankApi] ยิง Request ไปยัง API ธนาคารจริง (ตัด Quota/เครดิต)...");

        // Mock ผลลัพธ์ที่ตอบกลับมาจาก API ธนาคารภายนอก
        return SlipResult.success(500.00f, "2026-09-01T21:47:00+07:00", "260821203817131054");
    }
}
