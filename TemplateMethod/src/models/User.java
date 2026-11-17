/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author macbook
 */
class User {

    private String id;
    private String name;
    private String avatarUrl;
    private String email;

    public User(String id, String name, String avatarUrl, String email) {
        this.id = id;
        this.name = name;
        this.avatarUrl = avatarUrl;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("User{id='%s', name='%s', email='%s', avatar='%s'}",
                id,
                name,
                email,
                avatarUrl
        );
    }
}
