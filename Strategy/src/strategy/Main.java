/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package strategy;

import java.util.Arrays;
import java.util.List;
import models.FileArchiver;
import models.RarCompression;
import models.SevenZipCompression;
import models.TarGzCompression;
import models.ZipCompression;

/**
 *
 * @author macbook
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FileArchiver archiver = new FileArchiver();
        List<String> files = Arrays.asList("document.pdf", "photo.png", "data.csv");

        // 1. ZIP Strategy
        archiver.setStrategy(new ZipCompression());
        archiver.compress(files);

        // 2. RAR Strategy
        archiver.setStrategy(new RarCompression());
        archiver.compress(files);

        // 3. TAR.GZ Strategy
        archiver.setStrategy(new TarGzCompression());
        archiver.compress(files);

        // 4. 7Z Strategy
        archiver.setStrategy(new SevenZipCompression());
        archiver.compress(files);
    }

}
