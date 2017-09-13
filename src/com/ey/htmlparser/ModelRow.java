package com.ey.htmlparser;

import java.util.Date;

/**
 * Created by vvasund on 13.09.2017.
 */
public class ModelRow {
    public ModelRow() {
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public String getStatusLabel() {
        return statusLabel1;
    }

    public void setStatusLabel(String statusLabel) {
        this.statusLabel1 = statusLabel;
    }

    public String getOfficer() {
        return officer;
    }

    public void setOfficer(String officer) {
        this.officer = officer;
    }

    public String getStatusLabel1() {
        return statusLabel1;
    }

    public void setStatusLabel1(String statusLabel1) {
        this.statusLabel1 = statusLabel1;
    }

    public String getStatusLabel2() {
        return statusLabel2;
    }

    public void setStatusLabel2(String statusLabel2) {
        this.statusLabel2 = statusLabel2;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

//    public ModelRow(String classType, String statusLabel1,String statusLabel2, String officer, String startDate, String endDate, String address) {
//        this.classType = classType;
//        this.statusLabel1 = statusLabel1;
//        this.statusLabel2 = statusLabel2;
//        this.officer = officer;
//        this.startDate = startDate;
//        this.endDate = endDate;
//        this.address = address;
//    }

    public String classType;
    public String statusLabel1;
    public String statusLabel2;
    public String companyName;
    public String officer;
    public String startDate;
    public String endDate;
    public String address;
    public String country;
    public String relation;


}
