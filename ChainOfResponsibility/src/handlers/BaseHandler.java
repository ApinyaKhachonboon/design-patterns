/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package handlers;

import interfaces.Handler;
import models.Order;

/**
 *
 * @author macbook
 */
public abstract class BaseHandler implements Handler {

    private Handler nextHandler;

    @Override
    public Handler setNext(Handler handler) {
        this.nextHandler = handler;
        
        return nextHandler;
    }

    @Override
    public void handle(Order order) {
        if (nextHandler != null) {
            nextHandler.handle(order);
        }
    }
}
