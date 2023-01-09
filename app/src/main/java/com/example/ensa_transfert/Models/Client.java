package com.example.ensa_transfert.Models;

import com.example.ensa_transfert.Models.Enumerators.IdentityPaperType;

import java.util.List;

public class Client {

    private  Long id;
    private String gender;
    private String firstName;
    private String userName;
    private String lastName;
    private String email;
    private String password;
    private String birthday;
    private String cinNumber ;
    private String phoneNumber;
    private String country;
    private String zipCode;
    private String address;
    private String city;

    //private  double maxTransferAmountPerTransfer;

    private double maxTransferAmountPerYear;

    private IdentityPaperType identity_paper_type;

    private List<Beneficiary> beneficiaries ;

    List<Account> accounts ;


    public Client(Long id, String gender, String firstName, String userName, String lastName, String email, String password, String birthday, String cinNumber, String phoneNumber, String country, String zipCode, String address, String city, double maxTransferAmountPerYear, IdentityPaperType identity_paper_type, List<Beneficiary> beneficiaries, List<Account> accounts) {
        this.id = id;
        this.gender = gender;
        this.firstName = firstName;
        this.userName = userName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
        this.cinNumber = cinNumber;
        this.phoneNumber = phoneNumber;
        this.country = country;
        this.zipCode = zipCode;
        this.address = address;
        this.city = city;
        this.maxTransferAmountPerYear = maxTransferAmountPerYear;
        this.identity_paper_type = identity_paper_type;
        this.beneficiaries = beneficiaries;
        this.accounts = accounts;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCinNumber() {
        return cinNumber;
    }

    public void setCinNumber(String cinNumber) {
        this.cinNumber = cinNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getMaxTransferAmountPerYear() {
        return maxTransferAmountPerYear;
    }

    public void setMaxTransferAmountPerYear(double maxTransferAmountPerYear) {
        this.maxTransferAmountPerYear = maxTransferAmountPerYear;
    }

    public IdentityPaperType getIdentity_paper_type() {
        return identity_paper_type;
    }

    public void setIdentity_paper_type(IdentityPaperType identity_paper_type) {
        this.identity_paper_type = identity_paper_type;
    }

    public List<Beneficiary> getBeneficiaries() {
        return beneficiaries;
    }

    public void setBeneficiaries(List<Beneficiary> beneficiaries) {
        this.beneficiaries = beneficiaries;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", gender='" + gender + '\'' +
                ", firstName='" + firstName + '\'' +
                ", userName='" + userName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", birthday='" + birthday + '\'' +
                ", cinNumber='" + cinNumber + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", country='" + country + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", maxTransferAmountPerYear=" + maxTransferAmountPerYear +
                ", identity_paper_type=" + identity_paper_type +
                ", beneficiaries=" + beneficiaries +
                ", accounts=" + accounts +
                '}';
    }
}

