package com.FirearmMuseum.FirearmMuseum.models;

public class Firearm {

    private String name;
    private Caliber linkedCaliber;
    private String linkedManufacturer;
    private String linkedActionType;
    private String linkedFirearmType;
    private int productionDate;
    private int serialNumber;
    private String description;
    private String donatedBy;

    public Firearm(){

    }

    public Firearm(String name, Caliber linkedCaliber, String caliberName, String manufacturer, String actionType,
                   String firearmType, int productionDate, int serialNumber, String description, String donatedBy){

        this.name = name;
        this.linkedCaliber = linkedCaliber;
        this.linkedManufacturer = manufacturer;
        this.linkedActionType = actionType;
        this.linkedFirearmType = firearmType;
        this.productionDate = productionDate;
        this.serialNumber = serialNumber;
        this.description = description;
        this.donatedBy = donatedBy;

    }

    public Firearm(Firearm that){
        this.name = that.name;
        this.linkedCaliber = that.linkedCaliber;
        this.linkedFirearmType = that.linkedFirearmType;
        this.linkedActionType = that.linkedActionType;
        this.linkedManufacturer = that.linkedManufacturer;
        this.productionDate = that.productionDate;
        this.serialNumber = that.serialNumber;
        this.description = that.description;
        this.donatedBy = that.donatedBy;
    }
    public Caliber getLinkedCaliber() {
        return linkedCaliber;
    }

    public void setLinkedCaliber(Caliber linkedCaliber) {
        this.linkedCaliber = linkedCaliber;
    }

    public String getLinkedManufacturer() {
        return linkedManufacturer;
    }

    public void setLinkedManufacturer(String linkedManufacturer) {
        this.linkedManufacturer = linkedManufacturer;
    }

    public String getLinkedActionType() {
        return linkedActionType;
    }

    public void setLinkedActionType(String linkedActionType) {
        this.linkedActionType = linkedActionType;
    }

    public String getLinkedFirearmType() {
        return linkedFirearmType;
    }

    public void setLinkedFirearmType(String linkedFirearmType) {
        this.linkedFirearmType = linkedFirearmType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(int productionDate) {
        this.productionDate = productionDate;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDonatedBy() {
        return donatedBy;
    }

    public void setDonatedBy(String donatedBy) {
        this.donatedBy = donatedBy;
    }

}
