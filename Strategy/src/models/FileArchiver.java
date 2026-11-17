/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import interfaces.CompressionStrategy;
import java.util.List;

/**
 *
 * @author macbook
 */

public class FileArchiver {

    private CompressionStrategy compressionStrategy;

    public void setStrategy(CompressionStrategy compressionStrategy) {
        this.compressionStrategy = compressionStrategy;
    }

    public void compress(List<String> fileList) {
        if (compressionStrategy == null) {
            System.out.println("ต้อง set Strategy ก่อน");
            
            return;
        }
        
        compressionStrategy.compress(fileList);
    }
}
