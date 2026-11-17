/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import interfaces.SaleDocument;

/**
 *
 * @author macbook
 */
public abstract class DocumentDecorator implements SaleDocument {

    protected SaleDocument wrappedDocument; // Component ที่โดนสวมทับ

    public DocumentDecorator(SaleDocument wrappedDocument) {
        this.wrappedDocument = wrappedDocument;
    }

    @Override
    public String getDocumentNo() {
        return wrappedDocument.getDocumentNo();
    }

    @Override
    public double getFinalPrice() {
        return wrappedDocument.getFinalPrice();
    }

    @Override
    public String render() {
        return wrappedDocument.render();
    }
}
