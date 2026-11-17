/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author macbook
 */
public class Patient {

    private String id;
    private String name;
    private int age;
    private String triageLevel; // "RED", "YELLOW", "GREEN"
    private boolean isPregnant;
    private boolean requiresDisabilityCare;
    private String arrivalTime;

    public Patient(
            String id, 
            String name, 
            int age, 
            String triageLevel,
            boolean isPregnant, 
            boolean requiresDisabilityCare, 
            String arrivalTime
    ) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.triageLevel = triageLevel;
        this.isPregnant = isPregnant;
        this.requiresDisabilityCare = requiresDisabilityCare;
        this.arrivalTime = arrivalTime;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getTriageLevel() {
        return triageLevel;
    }

    public boolean isPregnant() {
        return isPregnant;
    }

    public boolean requiresDisabilityCare() {
        return requiresDisabilityCare;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }
}
