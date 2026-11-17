/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

/**
 *
 * @author macbook
 */
public class SlipResult {

    private boolean isValid;
    private float amount;
    private String transTimestamp;
    private String transRef;
    private String errorMessage;

    public SlipResult(boolean isValid, float amount, String transTimestamp, String transRef, String errorMessage) {
        this.isValid = isValid;
        this.amount = amount;
        this.transTimestamp = transTimestamp;
        this.transRef = transRef;
        this.errorMessage = errorMessage;
    }

    public static SlipResult failed(String errorMessage) {
        return new SlipResult(false, 0.0f, null, null, errorMessage);
    }

    public static SlipResult success(float amount, String transTimestamp, String transRef) {
        return new SlipResult(true, amount, transTimestamp, transRef, null);
    }

    public boolean isValid() {
        return isValid;
    }

    public float getAmount() {
        return amount;
    }

    public String getTransTimestamp() {
        return transTimestamp;
    }

    public String getTransRef() {
        return transRef;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
