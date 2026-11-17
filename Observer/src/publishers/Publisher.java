/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package publishers;

import interfaces.Observer;

/**
 *
 * @author macbook
 */
public interface Publisher {

    void subscribe(Observer s);

    void unsubscribe(Observer s);

    void broadcast();
}
