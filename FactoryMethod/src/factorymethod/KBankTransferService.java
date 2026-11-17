/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factorymethod;

/**
 *
 * @author macbook
 */
public class KBankTransferService extends BankTranferService {

    @Override
    public TransferProvider getTransferProvider() {
        KBankTransferProvider kbank = new KBankTransferProvider();
        
        kbank.setChrage(5.0);
        
        return kbank;
    }
    
}
