/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command;

import interfaces.Command;
import models.Order;
import receivers.KitchenService;

/**
 *
 * @author macbook
 */
public class PlaceOrderCommand implements Command {

    private KitchenService receiver;
    private Order order;

    public PlaceOrderCommand(KitchenService receiver, Order order) {
        this.receiver = receiver;
        this.order = order;
    }

    @Override
    public void execute() {
        receiver.processOrder(order);
    }
}
