/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factorymethod;

/**
 *
 * @author macbook
 */
public class KBankTransferProvider implements TransferProvider {

    double charge = 0;

    @Override
    public void setChrage(Double amount) {
        charge = amount;
    }

    @Override
    public double getChrage() {
        return charge;
    }

    @Override
    public boolean isValidAccount(String account) {
        System.out.println(account + " บัญชีเปิดใช้งานถูกต้อง");

        return true;
    }

    @Override
    public boolean isValidAmount(Double amount) {
        double total = amount + this.getChrage();

        System.out.println(total + " บัญชีมีเงินเพียงพอ");

        return true;
    }

    @Override
    public void transfer(String fromAccount, String toAccount, Double amount) {
        if (!isValidAccount(fromAccount)) {
            System.out.println("บัญชีต้นทางไม่ถูกต้อง");
            
            return;
        }

        if (!isValidAccount(toAccount)) {
            System.out.println("บัญชีปลายทางไม่ถูกต้อง");
            
            return;
        }

        if (!isValidAmount(amount)) {
            System.out.println("เงินไม่เพียงพอ");
            
            return;
        }
        
        System.out.printf("โอนเงินผ่าน KBank จำนวน %.2f สำเร็จ ค่าธรรมเนียมราคา %.2f\n", amount, getChrage());
    }

}
