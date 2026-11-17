/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import models.SaleDocument;

/**
 *
 * @author macbook
 */
public class TransactionRegistry {

    private static TransactionRegistry instance;
    private Map<String, List<SaleDocument>> saleDocs;
    private int idCounter = 1000;

    private TransactionRegistry() {
        saleDocs = new HashMap<>();
    }

    public static TransactionRegistry getInstance() {
        if (instance == null) {
            instance = new TransactionRegistry();
        }

        return instance;
    }

    public String generateNextId() {
        return "TX-" + (++idCounter);
    }

    public void addDocument(SaleDocument doc) {
        List<SaleDocument> docs = saleDocs.get(doc.getTransactionId());

        if (docs == null) {
            docs = new ArrayList<>();
            
            saleDocs.put(doc.getTransactionId(), docs);
        }

        docs.add(doc);
    }

    public void showTransaction(String transId) {
        System.out.println("\n==========================================");
        System.out.println("   FULL SALES FLOW DETAILS: " + transId);
        System.out.println("==========================================");

        List<SaleDocument> docs = saleDocs.get(transId);

        if (docs != null) {
            for (SaleDocument d : docs) {
                d.showInfo();
            }
        }
    }
}
