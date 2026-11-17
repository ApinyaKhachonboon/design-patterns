/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author macbook
 */
public class CheckupReport {

    private String patientInfo;
    private String vitalSignsResult;
    private String bloodTestResult;
    private String xrayResult;
    private String ekgResult;
    private String ultrasoundResult;

    public String getPatientInfo() {
        return patientInfo;
    }

    public void setPatientInfo(String patientInfo) {
        this.patientInfo = patientInfo;
    }

    public String getVitalSignsResult() {
        return vitalSignsResult;
    }

    public void setVitalSignsResult(String vitalSignsResult) {
        this.vitalSignsResult = vitalSignsResult;
    }

    public String getBloodTestResult() {
        return bloodTestResult;
    }

    public void setBloodTestResult(String bloodTestResult) {
        this.bloodTestResult = bloodTestResult;
    }

    public String getXrayResult() {
        return xrayResult;
    }

    public void setXrayResult(String xrayResult) {
        this.xrayResult = xrayResult;
    }

    public String getEkgResult() {
        return ekgResult;
    }

    public void setEkgResult(String ekgResult) {
        this.ekgResult = ekgResult;
    }

    public String getUltrasoundResult() {
        return ultrasoundResult;
    }

    public void setUltrasoundResult(String ultrasoundResult) {
        this.ultrasoundResult = ultrasoundResult;
    }

    public void printReport() {
        System.out.println("==================================================");
        System.out.println("รายงานผลการตรวจสุขภาพ (Medical Checkup Report)");
        System.out.println("==================================================");
        
        System.out.println("ผู้รับการตรวจ: " + patientInfo);
        System.out.println("ผลการวินิจฉัยทางการแพทย์:");
        
        if (vitalSignsResult != null) {
            System.out.println("  - " + vitalSignsResult);
        }
        
        if (bloodTestResult != null) {
            System.out.println("  - " + bloodTestResult);
        }
        
        if (xrayResult != null) {
            System.out.println("  - " + xrayResult);
        }
        
        if (ekgResult != null) {
            System.out.println("  - " + ekgResult);
        }
        
        if (ultrasoundResult != null) {
            System.out.println("  - " + ultrasoundResult);
        }
        
        System.out.println();
    }
}
