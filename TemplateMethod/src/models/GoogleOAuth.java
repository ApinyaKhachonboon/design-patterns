/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author macbook
 */
public class GoogleOAuth extends OAuthProvider {

    public GoogleOAuth(String clientId, String clientSecret) {
        super(clientId, clientSecret);
    }

    @Override
    public String requestAccessToken(String authCode) {
        System.out.println("[Google] Exchanging authCode '" + authCode + "' for Google Access Token...");
        
        return "google_access_token_xyz";
    }

    @Override
    public Map<String, String> fetchUserProfile(String token) {
        System.out.println("[Google] Fetching profile from https://www.googleapis.com/oauth2/v3/userinfo");
        
        Map<String, String> raw = new HashMap<>();
        raw.put("sub", "g_998877");
        raw.put("name", "Somchai Jaidee");
        raw.put("picture", "https://lh3.googleusercontent.com/a/somchai.png");
        raw.put("email", "somchai@gmail.com");
        
        return raw;
    }

    @Override
    public User mapToUserEntity(Map<String, String> raw) {
        // แปลงฟิลด์ของ Google (sub, name, picture, email) เป็น User กลาง
        return new User(
                raw.get("sub"),
                raw.get("name"),
                raw.get("picture"),
                raw.get("email")
        );
    }
}
