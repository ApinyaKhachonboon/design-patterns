/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factorymethod;

/**
 *
 * @author macbook
 */
public class SCBTransferService extends BankTranferService {

    @Override
    public TransferProvider getTransferProvider() {
        SCBTransferProvider scb = new SCBTransferProvider();
        
        scb.setChrage(10.0);
        
        return scb;
    }
    
}
