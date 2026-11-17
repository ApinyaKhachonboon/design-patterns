/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import interfaces.DenimFabric;

/**
 *
 * @author macbook
 */
public class AcidWashDenim implements DenimFabric {

    private String acidPatternStyle; // ลายสไตล์การฟอก (เช่น "Marble", "Snow-wash")
    private boolean isBleached;       // ผ่านการกัดสีระดับเข้มข้นหรือไม่

    public AcidWashDenim(String acidPatternStyle, boolean isBleached) {
        this.acidPatternStyle = acidPatternStyle;
        this.isBleached = isBleached;
    }

    public String getAcidPatternStyle() {
        return acidPatternStyle;
    }

    public void setAcidPatternStyle(String acidPatternStyle) {
        this.acidPatternStyle = acidPatternStyle;
    }

    public boolean isIsBleached() {
        return isBleached;
    }

    public void setIsBleached(boolean isBleached) {
        this.isBleached = isBleached;
    }

    @Override
    public String getTexture() {
        return "ผ้าฟอกลายด่างสไตล์ " + acidPatternStyle + (isBleached ? " (กัดสีเข้มข้น)" : "");
    }

    @Override
    public String getWashInstruction() {
        return "ซักแยกกับผ้าสีอ่อนเพื่อป้องกันสีตก";
    }

    @Override
    public String getStretchLevel() {
        return "ยืดหยุ่นปานกลาง";
    }
}
