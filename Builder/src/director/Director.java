/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package director;

import interfaces.Builder;

/**
 *
 * @author macbook
 */
public class Director {

    // ลำดับขั้นตอนการสร้างชุดตรวจพื้นฐาน
    public void makeBasicCheckup(Builder builder) {
        builder.reset();
        builder.buildPatientInfo();
        builder.buildVitalSigns();
        builder.buildBloodTest();
    }

    // ลำดับขั้นตอนการสร้างชุดตรวจแบบครบวงจร
    public void makeComprehensiveCheckup(Builder builder) {
        builder.reset();
        builder.buildPatientInfo();
        builder.buildVitalSigns();
        builder.buildBloodTest();
        builder.buildXray();
        builder.buildEkg();
        builder.buildUltrasound();
    }
}
