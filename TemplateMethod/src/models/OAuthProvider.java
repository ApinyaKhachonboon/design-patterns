/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Map;

/**
 *
 * @author macbook
 */
public abstract class OAuthProvider {

    protected String clientId;
    protected String clientSecret;

    public OAuthProvider(String clientId, String clientSecret) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    // ใช้ final เพื่อห้ามไม่ให้ Subclass มา override ลำดับขั้นตอนหลัก
    public final String authenticate(String authCode) {
        String token = requestAccessToken(authCode);
        
        Map<String, String> rawProfile = fetchUserProfile(token);
        
        User user = mapToUserEntity(rawProfile);

        // เรียก Hook (ถ้าคลาสลูกไม่ override ก็จะข้ามไปเฉยๆ)
        postFetchHook(token, user);

        return saveUserAndGenerateJwt(user);
    }

    // ทุกเจ้าใช้วิธีบันทึก DB และสร้าง JWT แบบเดียวกัน
    public String saveUserAndGenerateJwt(User user) {
        System.out.println("[DB] Saving user: " + user);
        
        String jwt = "jwt_token_for_" + user.getEmail();
        
        System.out.println("[Auth] Generated JWT: " + jwt);
        
        return jwt;
    }

    // Hook Method: ปล่อยว่างไว้เป็นค่าเริ่มต้น คลาสลูกเลือก override ได้ตามต้องการ
    public void postFetchHook(String token, User user) {
        // Default: ไม่ทำอะไร
    }

    // Abstract Methods: บังคับให้คลาสลูกทุกตัวต้องเขียนรายละเอียดเอง
    public abstract String requestAccessToken(String authCode);

    public abstract Map<String, String> fetchUserProfile(String token);

    public abstract User mapToUserEntity(Map<String, String> rawProfile);
}
