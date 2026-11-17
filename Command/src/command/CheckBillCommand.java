/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command;

import interfaces.Command;
import receivers.CashierService;

/**
 *
 * @author macbook
 */
public class CheckBillCommand implements Command {

    private final CashierService receiver;
    private final String tableNo;

    public CheckBillCommand(CashierService receiver, String tableNo) {
        this.receiver = receiver;
        this.tableNo = tableNo;
    }

    @Override
    public void execute() {
        receiver.generateBill(tableNo);
    }
}
