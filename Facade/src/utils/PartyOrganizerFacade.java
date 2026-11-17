/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import dtos.PartyBookingRequest;
import dtos.PartyBookingResult;
import services.CateringService;
import services.EntertainmentService;
import services.PaymentService;
import services.SoundLightingService;
import services.VenueService;

/**
 *
 * @author macbook
 */
public class PartyOrganizerFacade {

    private PartyBookingRequest request;
    private VenueService venueService;
    private CateringService cateringService;
    private SoundLightingService soundLightingService;
    private EntertainmentService entertainmentService;
    private PaymentService paymentService;

    private String activeBookingId;

    public PartyOrganizerFacade(PartyBookingRequest request) {
        this.request = request;
        this.venueService = new VenueService(
                request.getVenueName(), 
                request.getVenueCapacity(), 
                request.getVenueRentalFee()
        );
        this.cateringService = new CateringService();
        this.soundLightingService = new SoundLightingService(request.getSoundSystemWattage(), true);
        this.entertainmentService = new EntertainmentService();
        this.paymentService = new PaymentService();
    }
    
    // Method สั่งรันลำดับขั้นตอนการจองโดยใช้ข้อมูลจาก Attributes
    public PartyBookingResult organizeParty() {
        System.out.println(">>> เริ่มกระบวนการจองงานจัดเลี้ยง: " + request.getPartyName() + " <<<");

        this.activeBookingId = "TH-BK-" + System.currentTimeMillis() % 100000;

        // ขั้นตอนที่ 1: จองคิวสถานที่
        if (!venueService.reserveHall(request.getPartyDate(), request.getGuestCount())) {
            return new PartyBookingResult(
                    activeBookingId, 
                    request.getPartyName(), 
                    request.getPartyDate(), 
                    0, 
                    "FAILED_VENUE_UNAVAILABLE", 
                    null
            );
        }

        // ขั้นตอนที่ 2: เลือกแพ็กเกจอาหาร
        cateringService.selectMenu(
                request.getMenuPackageName(), 
                request.getPricePerHead(), 
                request.IsDietaryOptionIncluded()
        );

        // ขั้นตอนที่ 3: จัดการระบบไฟและเครื่องเสียง
        soundLightingService.installSoundSystem();
        soundLightingService.setupLights(request.getTheme());

        // ขั้นตอนที่ 4: ล็อกคิววงดนตรีและพิธีกร
        entertainmentService.bookBand(request.getBandName(), request.getBandFee());
        entertainmentService.assignMC(request.getMcName());

        // ขั้นตอนที่ 5: คำนวณค่าใช้จ่ายและชำระเงินมัดจำ
        double totalCost = venueService.getRentalFee()
                + cateringService.calculateFoodCost(request.getGuestCount())
                + soundLightingService.getServiceFee()
                + entertainmentService.getPerformanceFee();

        if (totalCost > request.getBudget()) {
            System.out.println(
                    "\n[แจ้งเตือนจาก Facade] "
                    + "ยอดรวมค่าใช้จ่าย (" + totalCost + " บาท) "
                    + "เกินกว่างบประมาณที่ตั้งไว้ (" + request.getBudget() + " บาท)!"
            );
        }

        String invoiceUrl = paymentService.issueInvoice(totalCost);
        
        paymentService.processDeposit(totalCost * 0.5); // ชำระมัดจำ 50%

        return new PartyBookingResult(
                activeBookingId, 
                request.getPartyName(), 
                request.getPartyDate(), 
                totalCost, 
                "CONFIRMED", 
                invoiceUrl
        );
    }

    public boolean cancelParty(String bookingId) {
        System.out.println("\n>>> ยกเลิกการจัดงานเลี้ยง รหัสการจอง: " + bookingId + " <<<");

        venueService.releaseHall();

        cateringService.cancelFood();

        soundLightingService.dismantle();

        entertainmentService.cancelLineup();

        paymentService.processRefund(bookingId);

        return true;
    }
}
