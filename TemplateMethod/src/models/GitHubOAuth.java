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
public class GitHubOAuth extends OAuthProvider {

    private String emailEndpoint = "https://api.github.com/user/emails";

    public GitHubOAuth(String clientId, String clientSecret) {
        super(clientId, clientSecret);
    }

    @Override
    public String requestAccessToken(String authCode) {
        System.out.println("[GitHub] Exchanging authCode '" + authCode + "' for GitHub Access Token...");
        
        return "gho_access_token_123";
    }

    @Override
    public Map<String, String> fetchUserProfile(String token) {
        System.out.println("[GitHub] Fetching profile from https://api.github.com/user");
        
        Map<String, String> raw = new HashMap<>();
        raw.put("id", "gh_554433");
        raw.put("login", "somchai-dev");
        raw.put("avatar_url", "https://avatars.githubusercontent.com/u/554433");
        // สมมติว่าผู้ใช้ตั้งค่าซ่อนอีเมลในหน้าโปรไฟล์หลัก ทำให้ email เป็น null
        raw.put("email", null);
        
        return raw;
    }

    @Override
    public User mapToUserEntity(Map<String, String> raw) {
        // แปลงฟิลด์ของ GitHub (id, login, avatar_url, email) เป็น User กลาง
        return new User(
                raw.get("id"),
                raw.get("login"),
                raw.get("avatar_url"),
                raw.get("email")
        );
    }

    // Override Hook เพื่อดึงอีเมลจาก Endpoint พิเศษของ GitHub
    @Override
    public void postFetchHook(String token, User user) {
        if (user.getEmail() == null) {
            System.out.println("[GitHub Hook] Email is private. Fetching primary email from " + emailEndpoint);
            
            user.setEmail("somchai.dev@github-private.com");
        }
    }
}
