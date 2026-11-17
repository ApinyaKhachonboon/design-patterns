/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import interfaces.PatientIterator;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author macbook
 */

public class SpecialPatientIterator implements PatientIterator {
    private List<Patient> patients = new ArrayList<>();
    private int currentIndex = 0;

    public SpecialPatientIterator(HospitalPatientCollection collection) {
        for (Patient p : collection.getPatients()) {
            if (p.getAge() >= 60 || p.isPregnant() || p.requiresDisabilityCare()) {
                this.patients.add(p);
            }
        }
    }

    @Override
    public boolean hasMore() {
        return currentIndex < patients.size();
    }

    @Override
    public Patient getNext() {
        if (!hasMore()) {
            return null;
        }
        
        return patients.get(currentIndex++);
    }
}
