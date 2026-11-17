/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package builder;

import interfaces.Builder;
import models.CheckupReport;

/**
 *
 * @author macbook
 */

public class CheckupReportBuilder implements Builder {
    private CheckupReport report;
    private String patientName;
    private int age;

    public CheckupReportBuilder(String patientName, int age) {
        this.reset();
        
        this.patientName = patientName;
        this.age = age;
    }

    @Override
    public void reset() {
        this.report = new CheckupReport();
    }

    @Override
    public void buildPatientInfo() {
        this.report.setPatientInfo(patientName + " (อายุ " + age + " ปี)");
    }

    @Override
    public void buildVitalSigns() {
        this.report.setVitalSignsResult("สัญญาณชีพ: ความดันโลหิต 120/80 mmHg, ชีพจร 72 bpm (ปกติ)");
    }

    @Override
    public void buildBloodTest() {
        this.report.setBloodTestResult("ตรวจเลือด: น้ำตาลในเลือด 92 mg/dL, ไขมันปกติ");
    }

    @Override
    public void buildXray() {
        this.report.setXrayResult("เอกซเรย์ปอด: ไม่พบความผิดปกติในช่องอก");
    }

    @Override
    public void buildEkg() {
        this.report.setEkgResult("คลื่นไฟฟ้าหัวใจ: จังหวะการเต้นสม่ำเสมอเป็นปกติ");
    }

    @Override
    public void buildUltrasound() {
        this.report.setUltrasoundResult("อัลตราซาวด์ช่องท้อง: ตับและไตขนาดปกติ ไม่พบนิ่ว");
    }

    public CheckupReport getResult() {
        return this.report;
    }
}
