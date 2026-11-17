/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proxy;

import dtos.SlipResult;
import interfaces.ISlipVerificationService;
import services.RealBankApiService;
import services.proxy.PreFilterSlipProxy;

/**
 *
 * @author macbook
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // กำหนดการเชื่อมต่อผ่าน Proxy
        ISlipVerificationService bankApi = new RealBankApiService("API_KEY_SECRET", "https://api.slipok.com/v1");
        ISlipVerificationService proxySlipService = new PreFilterSlipProxy(bankApi);

        // ทดสอบการส่งสลิปเข้าตรวจสอบ
        byte[] mockImage = new byte[]{1, 2, 3};
        
        SlipResult result = proxySlipService.verifySlip(mockImage);

        if (result.isValid()) {
            System.out.println("ผลลัพธ์: ตรวจสอบผ่าน");
            System.out.println("ยอดเงิน: " + result.getAmount() + " บาท");
            System.out.println("วันเวลา: " + result.getTransTimestamp());
            System.out.println("TransRef: " + result.getTransRef());
        } else {
            System.out.println("ผลลัพธ์: ไม่ผ่าน (" + result.getErrorMessage() + ")");
        }
    }

}
