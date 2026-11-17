package models;


import interfaces.SaleDocument;
import models.DocumentDecorator;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author macbook
 */
public class WatermarkDecorator extends DocumentDecorator {

    private String watermarkText; // ข้อความลายน้ำ
    private double opacity;       // ความโปร่งแสง

    public WatermarkDecorator(SaleDocument wrappedDocument, String watermarkText, double opacity) {
        super(wrappedDocument);
        
        this.watermarkText = watermarkText;
        this.opacity = opacity;
    }

    @Override
    public String render() {
        StringBuilder sb = new StringBuilder();
        
        sb.append(String.format("--- WATERMARK: [%s] (Opacity: %.1f) ---\n", watermarkText, opacity));
        sb.append(super.render());
        
        return sb.toString();
    }
}
