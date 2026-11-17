/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

/**
 *
 * @author macbook
 */
public interface Builder {

    void reset();

    void buildPatientInfo();

    void buildVitalSigns();

    void buildBloodTest();

    void buildXray();

    void buildEkg();

    void buildUltrasound();
}
