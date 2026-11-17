/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author macbook
 */
public class Receipt extends SaleDocument {

    private String paymentMethod;
    private String bankAccount;
    private String paymentDate;
    private boolean isDeposit = false;

    public Receipt(SaleDocument target) {
        super(target);
        
        if (target instanceof Receipt rv) {
            this.paymentMethod = rv.paymentMethod;
            this.bankAccount = rv.bankAccount;
            this.paymentDate = rv.paymentDate;
            this.isDeposit = rv.isDeposit;
        }
    }

    @Override
    public SaleDocument copy() {
        return new Receipt(this);
    }

    public void clearOutstandingBalance() {
        System.out.println(">>> Biz Logic: Outstanding balance cleared for customer: " + customerName);
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public boolean getIsDeposit() {
        return isDeposit;
    }

    public void setIsDeposit(boolean isDeposit) {
        this.isDeposit = isDeposit;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Method: " + paymentMethod + " | Bank: " + bankAccount + " | Deposit: " + isDeposit);
    }
}
