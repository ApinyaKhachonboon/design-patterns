/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import interfaces.Memento;

/**
 *
 * @author macbook
 */
public interface Originator {

    Memento save();

    void restore(Memento m);
}
