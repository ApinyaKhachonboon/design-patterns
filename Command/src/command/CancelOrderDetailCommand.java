/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command;

import interfaces.Command;
import models.OrderDetail;
import receivers.KitchenService;

/**
 *
 * @author macbook
 */
public class CancelOrderDetailCommand implements Command {

    private KitchenService receiver;
    private OrderDetail orderDetail;
    private String reason;

    public CancelOrderDetailCommand(KitchenService receiver, OrderDetail orderDetail, String reason) {
        this.receiver = receiver;
        this.orderDetail = orderDetail;
        this.reason = reason;
    }

    @Override
    public void execute() {
        receiver.cancelDetail(orderDetail, reason);
    }
}
