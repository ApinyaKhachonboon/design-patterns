/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package director;

import builder.CheckupInvoiceBuilder;
import builder.CheckupReportBuilder;
import models.CheckupInvoice;
import models.CheckupReport;

/**
 *
 * @author macbook
 */
public class Main {

    public static void client(String name, int age) {
        Director director = new Director();

        System.out.println(">>> สร้างแพ็กเกจตรวจครบวงจร (Comprehensive Checkup) <<<\n");

        CheckupReportBuilder fullReportBuilder = new CheckupReportBuilder(name, age);

        director.makeComprehensiveCheckup(fullReportBuilder);

        CheckupReport fullReport = fullReportBuilder.getResult();

        fullReport.printReport();

        CheckupInvoiceBuilder fullInvoiceBuilder = new CheckupInvoiceBuilder(name);

        director.makeComprehensiveCheckup(fullInvoiceBuilder);

        CheckupInvoice fullInvoice = fullInvoiceBuilder.getResult();

        fullInvoice.printInvoice();
    }

    public static void main(String[] args) {
        client("นายอภิญญา ขจรบุญ", 37);

        String name = "ทดสอบ ทดสอบ";
        int age = 20;
        CheckupReportBuilder customReportBuilder = new CheckupReportBuilder(name, age);

        customReportBuilder.reset();
        customReportBuilder.buildPatientInfo();
        customReportBuilder.buildBloodTest();
        customReportBuilder.buildUltrasound();
        customReportBuilder.buildEkg();

        CheckupReport cr = customReportBuilder.getResult();
        cr.printReport();

        CheckupInvoiceBuilder customInvoiceBuilder = new CheckupInvoiceBuilder(name);

        customInvoiceBuilder.reset();
        customInvoiceBuilder.buildPatientInfo();
        customInvoiceBuilder.buildBloodTest();
        customInvoiceBuilder.buildUltrasound();
        customInvoiceBuilder.buildEkg();

        CheckupInvoice ci = customInvoiceBuilder.getResult();
        ci.printInvoice();
    }
}
