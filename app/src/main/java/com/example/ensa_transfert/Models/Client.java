package com.example.ensa_transfert.Models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.example.ensa_transfert.Models.Enumerators.IdentityPaperType;

import java.util.List;

public class Client implements Parcelable {

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


    protected Client(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readLong();
        }
        gender = in.readString();
        firstName = in.readString();
        userName = in.readString();
        lastName = in.readString();
        email = in.readString();
        password = in.readString();
        birthday = in.readString();
        cinNumber = in.readString();
        phoneNumber = in.readString();
        country = in.readString();
        zipCode = in.readString();
        address = in.readString();
        city = in.readString();
        maxTransferAmountPerYear = in.readDouble();
        beneficiaries = in.createTypedArrayList(Beneficiary.CREATOR);
    }

    public static final Creator<Client> CREATOR = new Creator<Client>() {
        @Override
        public Client createFromParcel(Parcel in) {
            return new Client(in);
        }

        @Override
        public Client[] newArray(int size) {
            return new Client[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(id);
        }
        dest.writeString(gender);
        dest.writeString(firstName);
        dest.writeString(userName);
        dest.writeString(lastName);
        dest.writeString(email);
        dest.writeString(password);
        dest.writeString(birthday);
        dest.writeString(cinNumber);
        dest.writeString(phoneNumber);
        dest.writeString(country);
        dest.writeString(zipCode);
        dest.writeString(address);
        dest.writeString(city);
        dest.writeDouble(maxTransferAmountPerYear);
        dest.writeTypedList(beneficiaries);
    }
}

