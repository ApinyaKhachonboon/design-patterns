/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package templatemethod;

import models.GitHubOAuth;
import models.GoogleOAuth;
import models.OAuthProvider;

/**
 *
 * @author macbook
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        OAuthProvider googleOauth = new GoogleOAuth("g_client_id", "g_secret");
        OAuthProvider gitHubOauth = new GitHubOAuth("gh_client_id", "gh_secret");
        

        googleOauth.authenticate("auth_code_from_google");
        gitHubOauth.authenticate("auth_code_from_github");
    }

}
