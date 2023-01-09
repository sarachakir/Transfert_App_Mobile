package com.example.ensa_transfert.Models.ActivitiesModels;

public class BenefItem {
    String fullName;
    String number;

    public BenefItem(String fullName, String number) {
        this.fullName = fullName;
        this.number = number;
    }

    public BenefItem() {

    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
