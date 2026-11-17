/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author macbook
 */
import interfaces.Originator;
import interfaces.Memento;
import java.util.Stack;

public class Caretaker {

    private Stack<Memento> history = new Stack<>();
    private Originator originator;

    public Caretaker(Originator originator) {
        this.originator = originator;
    }

    public void addHistory() {
        Memento m = originator.save();
        
        history.push(m);
    }

    public void undo() {
        if (!history.isEmpty()) {
            System.out.print("[Undo] -> ");
            
            Memento m = history.pop();
            
            originator.restore(m);
        } else {
            System.out.println("No history left to undo.");
        }
    }
}
