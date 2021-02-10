package com.FirearmMuseum.FirearmMuseum.models;

public class Firearm {

    private Integer firearmId;
    private String name;
    private Integer linkedCaliberSize;
    private Integer linkedManufacturer;
    private Integer linkedActionType;
    private Integer linkedFirearmType;
    private Integer productionDate;
    private Integer serialNumber;
    private String description;
    private String donatedBy;


    public Firearm(){

    }

    public Firearm(String name, Integer linkedCaliberSize, Integer manufacturer, Integer actionType,
                   Integer firearmType, Integer productionDate, Integer serialNumber, String description, String donatedBy, Integer firearmId){

        this.firearmId = firearmId;
        this.name = name;
        this.linkedCaliberSize = linkedCaliberSize;
        this.linkedManufacturer = manufacturer;
        this.linkedActionType = actionType;
        this.linkedFirearmType = firearmType;
        this.productionDate = productionDate;
        this.serialNumber = serialNumber;
        this.description = description;
        this.donatedBy = donatedBy;

    }

    public Firearm(Firearm that){
        this.firearmId = that.firearmId;
        this.name = that.name;
        this.linkedCaliberSize = that.linkedCaliberSize;
        this.linkedFirearmType = that.linkedFirearmType;
        this.linkedActionType = that.linkedActionType;
        this.linkedManufacturer = that.linkedManufacturer;
        this.productionDate = that.productionDate;
        this.serialNumber = that.serialNumber;
        this.description = that.description;
        this.donatedBy = that.donatedBy;
    }

    public Integer getFirearmId() {
        return firearmId;
    }

    public void setFirearmId(Integer firearmId) {
        this.firearmId = firearmId;
    }

    public void setProductionDate(Integer productionDate) {
        this.productionDate = productionDate;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Integer getLinkedManufacturer() {
        return linkedManufacturer;
    }

    public void setLinkedManufacturer(Integer linkedManufacturer) {
        this.linkedManufacturer = linkedManufacturer;
    }

    public Integer getLinkedActionType() {
        return linkedActionType;
    }

    public void setLinkedActionType(Integer linkedActionType) {
        this.linkedActionType = linkedActionType;
    }

    public Integer getLinkedFirearmType() {
        return linkedFirearmType;
    }

    public void setLinkedFirearmType(Integer linkedFirearmType) {
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

    public Integer getLinkedCaliberSize() {
        return linkedCaliberSize;
    }

    public void setLinkedCaliberSize(Integer linkedCaliberSize) {
        this.linkedCaliberSize = linkedCaliberSize;
    }

}
