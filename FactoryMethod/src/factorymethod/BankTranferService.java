/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factorymethod;

/**
 *
 * @author macbook
 */
public abstract class BankTranferService {
    public abstract TransferProvider getTransferProvider();
    public void createTransferProvider(String fromAccount, String toAccount, Double amount) {
        TransferProvider tp = getTransferProvider();
        
        tp.transfer(fromAccount, toAccount, amount);
    };
}
