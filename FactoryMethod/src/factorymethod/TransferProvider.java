/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factorymethod;

/**
 *
 * @author macbook
 */
public interface TransferProvider {
    public void setChrage(Double amount);
    public double getChrage();
    public boolean isValidAccount(String account);
    public boolean isValidAmount(Double amount);
    public void transfer(String fromAccount, String toAccount, Double amount);
}
