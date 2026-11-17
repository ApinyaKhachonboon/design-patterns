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

public class SevenZipCompression implements CompressionStrategy {

    @Override
    public void compress(List<String> fileList) {
        System.out.println("Compressing files into .7Z format: " + fileList);
    }
}
