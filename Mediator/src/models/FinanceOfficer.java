/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author macbook
 */

public class FinanceOfficer extends ShowroomColleague {
    private String officerName;
    private int creditScoreLimit;

    public FinanceOfficer(String officerName, int creditScoreLimit) {
        this.officerName = officerName;
        this.creditScoreLimit = creditScoreLimit;
    }

    public void checkCreditBureau() {
        System.out.println(officerName + " (Finance) ตรวจสอบเครดิตบูโร");
    }

    public void calculateInstallment() {
        System.out.println(officerName + " (Finance) คำนวณค่างวดและเงินดาวน์");
        
        mediator.notify(this, "calculation_completed");
    }

    public void approveLoan() {
        System.out.println(officerName + " (Finance) อนุมัติสินเชื่อสำเร็จ");
        
        mediator.notify(this, "finance_approved");
    }
}
