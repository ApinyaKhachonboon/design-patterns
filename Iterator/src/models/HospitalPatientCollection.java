/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import interfaces.PatientCollection;
import interfaces.PatientIterator;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author macbook
 */
public class HospitalPatientCollection implements PatientCollection {

    private List<Patient> patients = new ArrayList<>();

    public void addPatient(Patient patient) {
        this.patients.add(patient);
    }

    public List<Patient> getPatients() {
        return patients;
    }

    @Override
    public PatientIterator createAllIterator() {
        return new AllPatientIterator(this);
    }

    @Override
    public PatientIterator createEmergencyIterator() {
        return new EmergencyPatientIterator(this);
    }

    @Override
    public PatientIterator createSpecialIterator() {
        return new SpecialPatientIterator(this);
    }
}
