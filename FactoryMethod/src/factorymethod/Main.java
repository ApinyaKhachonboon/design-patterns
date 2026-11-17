/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package factorymethod;

/**
 *
 * @author macbook
 */
public class Main {
    
    static BankTranferService client(BankTranferService bts, String fromAccount, String toAccount, double amount) {
        bts.createTransferProvider(fromAccount, toAccount, amount);
        
        return bts;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        client(new KBankTransferService(), "a", "b", 100);
//        client(new BBLTransferService(), "c", "d", 200);
//        client(new SCBTransferService(), "f", "g", 300);
        
        KBankTransferService kbt = new KBankTransferService();
        
        client(kbt, "me", "friend-1", 100);
        client(kbt, "me", "friend-2", 200);
        client(kbt, "me", "friend-3", 300);
    }
    
}
