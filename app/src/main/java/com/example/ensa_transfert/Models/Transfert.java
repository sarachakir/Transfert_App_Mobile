package com.example.ensa_transfert.Models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.example.ensa_transfert.Models.Enumerators.TransferStatus;
import com.example.ensa_transfert.Models.Enumerators.TransfertType;
import com.example.ensa_transfert.Models.Enumerators.TypeFrais;

import java.time.LocalDateTime;

public class Transfert implements Parcelable {

    private LocalDateTime receivedAt; // when the beneficiary receive their money we fill this attribute
    private String transferReference;
    private String codePin;

    private double transferAmount;
    private double transferCost;

    private double finalAmountOperation ;

    private double finalAmountTransfer ;

    private boolean toBeNotified;

    private TransferStatus status;

    private TransfertType type;

    private TypeFrais typeFrais;
    //private String motif;

    private String receiverFirstName; // beneficiary first  name

    private String receiverLastName; // beneficiary  last name

    private String receiverPhoneNumber; // beneficiary phone number

    private MTransfert mTransfer;

    public TypeFrais getTypeFrais() {
        return typeFrais;
    }

    public void setTypeFrais(TypeFrais typeFrais) {
        this.typeFrais = typeFrais;
    }

    public Transfert(LocalDateTime receivedAt, String transferReference, String codePin, double transferAmount, double transferCost, double finalAmountOperation, double finalAmountTransfer, boolean toBeNotified, TransferStatus status, TransfertType type, String receiverFirstName, String receiverLastName, String receiverPhoneNumber, MTransfert mTransfer) {
        this.receivedAt = receivedAt;
        this.transferReference = transferReference;
        this.codePin = codePin;
        this.transferAmount = transferAmount;
        this.transferCost = transferCost;
        this.finalAmountOperation = finalAmountOperation;
        this.finalAmountTransfer = finalAmountTransfer;
        this.toBeNotified = toBeNotified;
        this.status = status;
        this.type = type;
        this.receiverFirstName = receiverFirstName;
        this.receiverLastName = receiverLastName;
        this.receiverPhoneNumber = receiverPhoneNumber;
        this.mTransfer = mTransfer;
    }

    public Transfert(){

    }

    protected Transfert(Parcel in) {
        transferReference = in.readString();
        codePin = in.readString();
        transferAmount = in.readDouble();
        transferCost = in.readDouble();
        finalAmountOperation = in.readDouble();
        finalAmountTransfer = in.readDouble();
        toBeNotified = in.readByte() != 0;
        receiverFirstName = in.readString();
        receiverLastName = in.readString();
        receiverPhoneNumber = in.readString();
    }

    public static final Creator<Transfert> CREATOR = new Creator<Transfert>() {
        @Override
        public Transfert createFromParcel(Parcel in) {
            return new Transfert(in);
        }

        @Override
        public Transfert[] newArray(int size) {
            return new Transfert[size];
        }
    };

    public LocalDateTime getReceivedAt() {
        return receivedAt;
    }

    public void setReceivedAt(LocalDateTime receivedAt) {
        this.receivedAt = receivedAt;
    }

    public String getTransferReference() {
        return transferReference;
    }

    public void setTransferReference(String transferReference) {
        this.transferReference = transferReference;
    }

    public String getCodePin() {
        return codePin;
    }

    public void setCodePin(String codePin) {
        this.codePin = codePin;
    }

    public double getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(double transferAmount) {
        this.transferAmount = transferAmount;
    }

    public double getTransferCost() {
        return transferCost;
    }

    public void setTransferCost(double transferCost) {
        this.transferCost = transferCost;
    }

    public double getFinalAmountOperation() {
        return finalAmountOperation;
    }

    public void setFinalAmountOperation(double finalAmountOperation) {
        this.finalAmountOperation = finalAmountOperation;
    }

    public double getFinalAmountTransfer() {
        return finalAmountTransfer;
    }

    public void setFinalAmountTransfer(double finalAmountTransfer) {
        this.finalAmountTransfer = finalAmountTransfer;
    }

    public boolean isToBeNotified() {
        return toBeNotified;
    }

    public void setToBeNotified(boolean toBeNotified) {
        this.toBeNotified = toBeNotified;
    }

    public TransferStatus getStatus() {
        return status;
    }

    public void setStatus(TransferStatus status) {
        this.status = status;
    }

    public TransfertType getType() {
        return type;
    }

    public void setType(TransfertType type) {
        this.type = type;
    }

    public String getReceiverFirstName() {
        return receiverFirstName;
    }

    public void setReceiverFirstName(String receiverFirstName) {
        this.receiverFirstName = receiverFirstName;
    }

    public String getReceiverLastName() {
        return receiverLastName;
    }

    public void setReceiverLastName(String receiverLastName) {
        this.receiverLastName = receiverLastName;
    }

    public String getReceiverPhoneNumber() {
        return receiverPhoneNumber;
    }

    public void setReceiverPhoneNumber(String receiverPhoneNumber) {
        this.receiverPhoneNumber = receiverPhoneNumber;
    }

    public MTransfert getmTransfer() {
        return mTransfer;
    }

    public void setmTransfer(MTransfert mTransfer) {
        this.mTransfer = mTransfer;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(transferReference);
        dest.writeString(codePin);
        dest.writeDouble(transferAmount);
        dest.writeDouble(transferCost);
        dest.writeDouble(finalAmountOperation);
        dest.writeDouble(finalAmountTransfer);
        dest.writeByte((byte) (toBeNotified ? 1 : 0));
        dest.writeString(receiverFirstName);
        dest.writeString(receiverLastName);
        dest.writeString(receiverPhoneNumber);
    }

    @Override
    public String toString() {
        return "Transfert{" +
                "receivedAt=" + receivedAt +
                ", transferReference='" + transferReference + '\'' +
                ", codePin='" + codePin + '\'' +
                ", transferAmount=" + transferAmount +
                ", transferCost=" + transferCost +
                ", finalAmountOperation=" + finalAmountOperation +
                ", finalAmountTransfer=" + finalAmountTransfer +
                ", toBeNotified=" + toBeNotified +
                ", status=" + status +
                ", type=" + type +
                ", receiverFirstName='" + receiverFirstName + '\'' +
                ", receiverLastName='" + receiverLastName + '\'' +
                ", receiverPhoneNumber='" + receiverPhoneNumber + '\'' +
                ", mTransfer=" + mTransfer +
                '}';
    }
}
