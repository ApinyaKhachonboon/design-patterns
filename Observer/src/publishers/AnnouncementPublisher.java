/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package publishers;

import interfaces.Observer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author macbook
 */
public class AnnouncementPublisher implements Publisher {

    private List<Observer> observers = new ArrayList<>();
    private String message;
    private String name;
    
    public AnnouncementPublisher(String name) {
        this.name = name;
    }

    @Override
    public void subscribe(Observer s) {
        observers.add(s);
    }

    @Override
    public void unsubscribe(Observer s) {
        observers.remove(s);
    }

    @Override
    public void broadcast() {
        for (Observer s : observers) {
            s.update(this.message);
        }
    }

    public void setMessage(String message) {
        this.message = "ประกาศจาก" + name + " " + message;
        
        broadcast();
    }
}
