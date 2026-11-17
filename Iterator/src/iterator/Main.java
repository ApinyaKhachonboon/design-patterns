/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package iterator;

import interfaces.PatientIterator;
import models.HospitalPatientCollection;
import models.Patient;

/**
 *
 * @author macbook
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HospitalPatientCollection hospital = new HospitalPatientCollection();

        // เพิ่มข้อมูลผู้ป่วย (id, ชื่อ, อายุ, triageLevel, ตั้งครรภ์, ต้องใช้วีลแชร์/ผู้พิการ, วันที่และเวลาที่มาถึง)
        hospital.addPatient(new Patient("P01", "นายสมชาย ใจดี", 25, "GREEN", false, false, "2026-10-09 08:00"));
        hospital.addPatient(new Patient("P02", "นายสมศักดิ์ กล้าหาญ", 45, "RED", false, false, "2026-10-09 08:05"));
        hospital.addPatient(new Patient("P03", "นางสมหญิง รักสงบ", 68, "GREEN", false, false, "2026-10-09 08:10"));
        hospital.addPatient(new Patient("P04", "น.ส.วิภา มีสุข", 30, "YELLOW", true, false, "2026-10-09 08:15"));
        hospital.addPatient(new Patient("P05", "นายประเสริฐ ชื่นบาน", 72, "RED", false, true, "2026-10-09 08:20"));

        System.out.println("=== 1. คิวผู้ป่วยฉุกเฉินวิกฤต (Emergency - RED) ===");
        PatientIterator emergencyIterator = hospital.createEmergencyIterator();
        while (emergencyIterator.hasMore()) {
            Patient p = emergencyIterator.getNext();
            
            System.out.println("รหัส: " + p.getId()
                    + " | ชื่อ: " + p.getName()
                    + " | ระดับ: " + p.getTriageLevel()
                    + " | เวลาเข้ารับบริการ: " + p.getArrivalTime());
        }

        System.out.println("\n=== 2. คิวกลุ่มช่วยเหลือพิเศษ (Special - ผู้สูงอายุ/มีครรภ์/ผู้พิการ) ===");
        
        PatientIterator specialIterator = hospital.createSpecialIterator();
        while (specialIterator.hasMore()) {
            Patient p = specialIterator.getNext();
            
            System.out.println("รหัส: " + p.getId()
                    + " | ชื่อ: " + p.getName()
                    + " | อายุ: " + p.getAge()
                    + " ปี | มีครรภ์: " + (p.isPregnant() ? "ใช่" : "ไม่ใช่")
                    + " | วีลแชร์: " + (p.requiresDisabilityCare() ? "ใช่" : "ไม่ใช่")
                    + " | เวลาเข้ารับบริการ: " + p.getArrivalTime());
        }

        System.out.println("\n=== 3. คิวผู้ป่วยทั้งหมด (All Patients) ===");
        
        PatientIterator allIterator = hospital.createAllIterator();
        
        while (allIterator.hasMore()) {
            Patient p = allIterator.getNext();
            
            System.out.println("รหัส: " + p.getId()
                    + " | ชื่อ: " + p.getName()
                    + " | ระดับ: " + p.getTriageLevel()
                    + " | เวลาเข้ารับบริการ: " + p.getArrivalTime());
        }
    }

}
