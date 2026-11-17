/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factorymethod;

/**
 *
 * @author macbook
 */
public class BBLTransferService extends BankTranferService {

    @Override
    public TransferProvider getTransferProvider() {
        BBLTransferProvider bbl = new BBLTransferProvider();
        
        bbl.setChrage(15.0);
        
        return bbl;
    }
    
}
