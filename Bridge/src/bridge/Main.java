/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bridge;

import interfaces.DenimFabric;
import models.AcidWashDenim;
import models.Jeans;
import models.RawDenim;
import models.SkinnyJeans;
import models.StraightJeans;
import models.StretchyDenim;
import models.WideLegJeans;

/**
 *
 * @author macbook
 */
public class Main {

    static void client() {
        DenimFabric rawFabric = new RawDenim(14, 5);
        DenimFabric stretchyFabric = new StretchyDenim(4, true);
        DenimFabric acidWashFabric = new AcidWashDenim("Marble Snow", true);

        // ทรง Skinny จับคู่กับ ผ้ายืด
        Jeans skinnyStretchy = new SkinnyJeans(stretchyFabric, "SK-Flex-01", 30, 32, 1200.0, 5.5, true);

        // ทรง Straight จับคู่กับ ผ้าดิบ
        Jeans straightRaw = new StraightJeans(rawFabric, "ST-Vintage-501", 32, 34, 1800.0, 8.0, "Button Fly");

        // ทรง Wide Leg จับคู่กับ ผ้าฟอก
        Jeans wideAcid = new WideLegJeans(acidWashFabric, "WD-Retro-80s", 28, 30, 1500.0, 38.0, true);

        skinnyStretchy.displayDetails();
        straightRaw.displayDetails();
        wideAcid.displayDetails();
    }

    public static void main(String[] args) {
        client();
    }
}
