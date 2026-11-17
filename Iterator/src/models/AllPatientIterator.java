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

public class AllPatientIterator implements PatientIterator {

    private List<Patient> patients = new ArrayList<>();
    private int currentIndex = 0;

    public AllPatientIterator(HospitalPatientCollection collection) {
        for (Patient p : collection.getPatients()) {
            this.patients.add(p);
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
