/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package invokers;

import interfaces.Command;
import interfaces.OrderChannelInvoker;

/**
 *
 * @author macbook
 */
public class QrOrderingInvoker implements OrderChannelInvoker {
    private Command command;

    @Override
    public void setCommand(Command command) {
        this.command = command;
    }

    @Override
    public void executeCommand() {
        System.out.print("[Channel: QR Ordering] -> ");
        
        if (command != null) {
            command.execute();
        }
    }
}
