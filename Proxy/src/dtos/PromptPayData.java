/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

/**
 *
 * @author macbook
 */
public class PromptPayData {

    private String bankCode;
    private String transRef;
    private String rawPayload;

    public PromptPayData(String bankCode, String transRef, String rawPayload) {
        this.bankCode = bankCode;
        this.transRef = transRef;
        this.rawPayload = rawPayload;
    }

    public String getBankCode() {
        return bankCode;
    }

    public String getTransRef() {
        return transRef;
    }

    public String getRawPayload() {
        return rawPayload;
    }
}
