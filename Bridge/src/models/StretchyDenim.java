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
public class StretchyDenim implements DenimFabric {

    private int spandexPct;     // สัดส่วนความยืดหยุ่น Spandex (เช่น 2%, 5%)
    private boolean isSoftened; // สถานะว่าผ่านกระบวนการนวดผ้าให้นุ่มแล้วหรือยัง

    public StretchyDenim(int spandexPct, boolean isSoftened) {
        this.spandexPct = spandexPct;
        this.isSoftened = isSoftened;
    }

    public int getSpandexPct() {
        return spandexPct;
    }

    public void setSpandexPct(int spandexPct) {
        this.spandexPct = spandexPct;
    }

    public boolean isIsSoftened() {
        return isSoftened;
    }

    public void setIsSoftened(boolean isSoftened) {
        this.isSoftened = isSoftened;
    }

    @Override
    public String getTexture() {
        return "ผ้ายีนส์ผสมสแปนเด็กซ์ เนื้อนุ่มนวล " + (isSoftened ? "(ผ่านการนวดผ้าแล้ว)" : "");
    }

    @Override
    public String getWashInstruction() {
        return "ซักเครื่องได้ตามปกติด้วยน้ำเย็น ไม่ควรใช้น้ำยาอบผ้า";
    }

    @Override
    public String getStretchLevel() {
        return "ยืดหยุ่นสูง (Spandex " + spandexPct + "%)";
    }
}
