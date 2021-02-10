package com.FirearmMuseum.FirearmMuseum.models;

import java.util.List;

public class Caliber {

    private double caliberSize;
    private String caliberUnit;
    private Integer caliberId;

    public List<Firearm> getAllFirearms() {
        return allFirearms;
    }

    public void setAllFirearms(List<Firearm> allFirearms) {
        this.allFirearms = allFirearms;
    }

    List<Firearm> allFirearms;

    public Integer getCaliberId() {
        return caliberId;
    }

    public void setCaliberId(Integer caliberId) {
        this.caliberId = caliberId;
    }

    public double getCaliberSize() {
        return caliberSize;
    }

    public void setCaliberSize(double caliberSize) {
        this.caliberSize = caliberSize;
    }

    public String getCaliberUnit() {
        return caliberUnit;
    }

    public void setCaliberUnit(String caliberUnit) {
        this.caliberUnit = caliberUnit;
    }



}
