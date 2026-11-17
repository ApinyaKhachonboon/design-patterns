/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import java.util.Date;

/**
 *
 * @author macbook
 */
public class PartyBookingRequest {

    private String partyName;
    private Date partyDate;
    private int guestCount;
    private double budget;
    private String theme;

    // ข้อมูลสำหรับ new VenueService
    private String venueName;
    private int venueCapacity;
    private double venueRentalFee;

    // ข้อมูลสำหรับ new CateringService
    private String menuPackageName;
    private double pricePerHead;
    private boolean isDietaryOptionIncluded;

    // ข้อมูลสำหรับ new SoundLightingService
    private int soundSystemWattage;

    // ข้อมูลสำหรับ new EntertainmentService
    private String bandName;
    private double bandFee;
    private String mcName;

    public PartyBookingRequest(
            String partyName, 
            Date partyDate, 
            int guestCount, 
            double budget, 
            String theme,
            String venueName, 
            int venueCapacity, 
            double venueRentalFee,
            String menuPackageName,
            boolean isDietaryOptionIncluded,
            double pricePerHead, 
            int soundSystemWattage,
            String bandName, 
            double bandFee, 
            String mcName
    ) {
        this.partyName = partyName;
        this.partyDate = partyDate;
        this.guestCount = guestCount;
        this.budget = budget;
        this.theme = theme;
        
        this.venueName = venueName;
        this.venueCapacity = venueCapacity;
        this.venueRentalFee = venueRentalFee;
        
        this.menuPackageName = menuPackageName;
        this.pricePerHead = pricePerHead;
        this.isDietaryOptionIncluded = isDietaryOptionIncluded;
        
        this.soundSystemWattage = soundSystemWattage;
        
        this.bandName = bandName;
        this.bandFee = bandFee;
        this.mcName = mcName;
    }

    public String getPartyName() {
        return partyName;
    }

    public Date getPartyDate() {
        return partyDate;
    }

    public int getGuestCount() {
        return guestCount;
    }

    public double getBudget() {
        return budget;
    }

    public String getTheme() {
        return theme;
    }

    public String getVenueName() {
        return venueName;
    }

    public int getVenueCapacity() {
        return venueCapacity;
    }

    public double getVenueRentalFee() {
        return venueRentalFee;
    }

    public String getMenuPackageName() {
        return menuPackageName;
    }
    
    public boolean IsDietaryOptionIncluded() {
        return isDietaryOptionIncluded;
    }

    public double getPricePerHead() {
        return pricePerHead;
    }

    public int getSoundSystemWattage() {
        return soundSystemWattage;
    }

    public String getBandName() {
        return bandName;
    }

    public double getBandFee() {
        return bandFee;
    }

    public String getMcName() {
        return mcName;
    }
}
