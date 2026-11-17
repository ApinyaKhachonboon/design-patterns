/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import interfaces.SaleDocument;

/**
 *
 * @author macbook
 */
public class SecurityInfoDecorator extends DocumentDecorator {

    private boolean maskPhone;
    private boolean maskEmail;

    public SecurityInfoDecorator(SaleDocument wrappedDocument, boolean maskPhone, boolean maskEmail) {
        super(wrappedDocument);
        
        this.maskPhone = maskPhone;
        this.maskEmail = maskEmail;
    }

    @Override
    public String render() {
        String content = super.render();

        if (maskPhone) {
            content = content.replaceAll("(เบอร์โทรศัพท์ \\(Phone\\)\t: \\d{3}-)\\d{3}-\\d{4}", "$1XXX-XXXX");
        }
        
        //[^@\s]+      = ชื่อผู้ใช้อีเมล (อ่านตัวอักษรอะไรก็ได้ยาวไปเรื่อยๆ จนกว่าจะเจอ @ หรือช่องว่าง)
        if (maskEmail) {
            content = content.replaceAll("(อีเมล \\(Email\\)\t: )[^@\\s]+(@.+)", "$1[RESTRICTED_EMAIL]$2");
        }

        StringBuilder sb = new StringBuilder(content);

        sb.append("-----------------------------------------------------------------\n");
        sb.append("[PDPA / PRIVACY PROTECTED] Phone & Email masked for security.\n");

        return sb.toString();
    }
}
