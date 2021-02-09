package com.FirearmMuseum.FirearmMuseum.models;

public class Firearm {

    private String name;
    private double caliberNumber;
    private String caliberName;
    private String manufacturer;
    private String actionType;
    private String firearmType;
    private int productionDate;
    private int serialNumber;
    private String description;
    private String donatedBy;

    public Firearm(){

    }

    public Firearm(String name, double caliberNumber, String caliberName, String manufacturer, String actionType,
                   String firearmType, int productionDate, int serialNumber, String description, String donatedBy){
        this.name = name;
        this.caliberNumber = caliberNumber;
        this.caliberName = caliberName;
        this.manufacturer = manufacturer;
        this.actionType = actionType;
        this.firearmType = firearmType;
        this.productionDate = productionDate;
        this.serialNumber = serialNumber;
        this.description = description;
        this.donatedBy = donatedBy;
    }

    public Firearm(Firearm that){
        this.name = that.name;
        this.caliberNumber = that.caliberNumber;
        this.caliberName = that.caliberName;
        this.manufacturer = that.manufacturer;
        this.actionType = that.actionType;
        this.firearmType = that.firearmType;
        this.productionDate = that.productionDate;
        this.serialNumber = that.serialNumber;
        this.description = that.description;
        this.donatedBy = that.donatedBy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCaliberNumber() {
        return caliberNumber;
    }

    public void setCaliberNumber(double caliberNumber) {
        this.caliberNumber = caliberNumber;
    }

    public String getCaliberName() {
        return caliberName;
    }

    public void setCaliberName(String caliberName) {
        this.caliberName = caliberName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getFirearmType() {
        return firearmType;
    }

    public void setFirearmType(String firearmType) {
        this.firearmType = firearmType;
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
