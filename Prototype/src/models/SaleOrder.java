/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author macbook
 */
public class SaleOrder extends SaleDocument {

    private String docRef;
    private String customerPO;
    private String internalRemark;

    public SaleOrder(SaleDocument target) {
        super(target);

        if (target instanceof SaleOrder saleOrder) {
            this.docRef = saleOrder.docRef;
            this.customerPO = saleOrder.customerPO;
            this.internalRemark = saleOrder.internalRemark;
        }
    }

    @Override
    public SaleDocument copy() {
        return new SaleOrder(this);
    }

    public void reserveStock() {
        System.out.println(">>> Biz Logic: Items reserved in warehouse for SO: " + docNo);
    }

    @Override
    public void showInfo() {
        super.showInfo();

        System.out.println("Ref QT: " + docRef + " | Customer PO: " + customerPO + " | Remark: " + internalRemark);
    }

    public String getDocRef() {
        return docRef;
    }

    public void setDocRef(String docRef) {
        this.docRef = docRef;
    }

    public String getCustomerPO() {
        return customerPO;
    }

    public void setCustomerPO(String customerPO) {
        this.customerPO = customerPO;
    }

    public String getInternalRemark() {
        return internalRemark;
    }

    public void setInternalRemark(String internalRemark) {
        this.internalRemark = internalRemark;
    }

}
