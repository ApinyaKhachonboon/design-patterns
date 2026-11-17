/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prototype;

import models.DeliveryOrder;
import models.Invoice;
import models.Item;
import models.Quotation;
import models.Receipt;
import models.SaleOrder;
import services.TransactionRegistry;

/**
 *
 * @author macbook
 */
public class Main {

    public static void client() {
        TransactionRegistry registry = TransactionRegistry.getInstance();

        String currentTxId = registry.generateNextId();

        // --- STEP 1: QUOTATION ---
        Quotation qt = new Quotation();

        qt.setTransactionId(currentTxId);

        qt.setDocNo("QT-001");
        qt.setDocDate("2026-08-07");
        qt.setCustomerName("Manee Co., Ltd.");
        qt.setCustomerAddress("123 Sukhumvit, Bangkok");
        qt.setPreparedBy("Sale-Agent-A");
        qt.getItems().add(new Item("High-End Server", 50000, 2));

        // Set ฟิลด์เฉพาะของ QT
        qt.setPaymentTerms("Cash");
        qt.setDueDate("2026-12-31");
        qt.setSalesPerson("Mr. Somchai");
        qt.setDiscountRate(10.0);
        qt.setTotalAmount(qt.calculateAmoutWithDiscount());
        qt.setVersion(1);
        qt.setStatus("Approved");

        registry.addDocument(qt);

        // --- STEP 2: SALE ORDER ---
        SaleOrder so = new SaleOrder(qt.copy());

        so.setDocNo("SO-001");
        so.setPreparedBy("Sale-Manager-A");

        // Set ฟิลด์เฉพาะของ SO ทีละตัว
        so.setDocRef(qt.getDocNo());
        so.setCustomerPO("CUST-PO-99");
        so.setInternalRemark("ด่วนมาก");
        so.setStatus("Approved");

        so.reserveStock();

        registry.addDocument(so);

        // --- STEP 3: DELIVERY ORDER ---
        DeliveryOrder doDoc = new DeliveryOrder(so.copy());

        doDoc.setDocNo("DO-001");
        doDoc.setPreparedBy("Warehouse-Staff-A");

        // Set ฟิลด์เฉพาะของ DO ทีละตัว
        doDoc.setShipping(so.getCustomerAddress(), "2026-08-15");
        doDoc.setCarrierName("Flash Express");
        doDoc.setTrackingNumber("FE-0001");
        doDoc.setReceiverName("Ms. Manee");
        doDoc.setStatus("Shipped");

        doDoc.deductStock();

        registry.addDocument(doDoc);

        // --- STEP 4: INVOICE (เข้าสู่กระบวนการบัญชี) ---
        Invoice iv = new Invoice(doDoc.copy());

        iv.setDocNo("IV-001");
        iv.setPreparedBy("Accountant-A");

        // Set ฟิลด์เฉพาะของ IV ทีละตัว
        iv.setTaxId("0105560000000");
        iv.setVatAmount(iv.calculateVat());
        iv.setNetAmount(iv.getTotalAmount());
        iv.setStatus("Paid");

        iv.postToAccount();

        registry.addDocument(iv);

        // --- STEP 5: RECEIPT (จบกระบวนการ) ---
        Receipt rv = new Receipt(iv.copy());

        rv.setDocNo("RV-001");
        rv.setPreparedBy("Cashier-A");

        // Set ฟิลด์เฉพาะของ RV ทีละตัว
        rv.setPaymentMethod("Bank Transfer");
        rv.setBankAccount("SCB 111-2-22222-2");
        rv.setPaymentDate("2026-08-20");
        rv.setStatus("Completed");

        rv.clearOutstandingBalance();

        registry.addDocument(rv);

        // แสดงผลลัพธ์ทั้งสายงาน
        registry.showTransaction(currentTxId);
    }

    public static void main(String[] args) {
        client();
    }

}
