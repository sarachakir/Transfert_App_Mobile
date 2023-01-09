package com.example.ensa_transfert.Models;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDateTime;
import java.util.List;

@RequiresApi(api = Build.VERSION_CODES.O)
public class MTransfert {

    private LocalDateTime createdAt = LocalDateTime .now();
    private LocalDateTime  endedAt = createdAt.plusDays(4); //

    private Integer id_client=0;

    private double totalAmount;

    private String motif; // motif for all transfers within this multi transfer

    private double total_expense_amount;

    private String senderFirstName;


    private String senderLastName;

    private String senderPhoneNumber;


    private boolean prospect_client;

    private Integer sentByAgentWithId;

    private boolean transferByCash;

    //private int expense_id;  // ???

    private boolean notifyBeneficiary;

    private List<Transfert> transfers;

    public MTransfert(LocalDateTime createdAt, LocalDateTime endedAt, Integer id_client, double totalAmount, String motif, double total_expense_amount, String senderFirstName, String senderLastName, String senderPhoneNumber, boolean prospect_client, Integer sentByAgentWithId, boolean transferByCash, boolean notifyBeneficiary, List<Transfert> transfers) {
        this.createdAt = createdAt;
        this.endedAt = endedAt;
        this.id_client = id_client;
        this.totalAmount = totalAmount;
        this.motif = motif;
        this.total_expense_amount = total_expense_amount;
        this.senderFirstName = senderFirstName;
        this.senderLastName = senderLastName;
        this.senderPhoneNumber = senderPhoneNumber;
        this.prospect_client = prospect_client;
        this.sentByAgentWithId = sentByAgentWithId;
        this.transferByCash = transferByCash;
        this.notifyBeneficiary = notifyBeneficiary;
        this.transfers = transfers;
    }

    public MTransfert(){

    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getEndedAt() {
        return endedAt;
    }

    public void setEndedAt(LocalDateTime endedAt) {
        this.endedAt = endedAt;
    }

    public Integer getId_client() {
        return id_client;
    }

    public void setId_client(Integer id_client) {
        this.id_client = id_client;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public double getTotal_expense_amount() {
        return total_expense_amount;
    }

    public void setTotal_expense_amount(double total_expense_amount) {
        this.total_expense_amount = total_expense_amount;
    }

    public String getSenderFirstName() {
        return senderFirstName;
    }

    public void setSenderFirstName(String senderFirstName) {
        this.senderFirstName = senderFirstName;
    }

    public String getSenderLastName() {
        return senderLastName;
    }

    public void setSenderLastName(String senderLastName) {
        this.senderLastName = senderLastName;
    }

    public String getSenderPhoneNumber() {
        return senderPhoneNumber;
    }

    public void setSenderPhoneNumber(String senderPhoneNumber) {
        this.senderPhoneNumber = senderPhoneNumber;
    }

    public boolean isProspect_client() {
        return prospect_client;
    }

    public void setProspect_client(boolean prospect_client) {
        this.prospect_client = prospect_client;
    }

    public Integer getSentByAgentWithId() {
        return sentByAgentWithId;
    }

    public void setSentByAgentWithId(Integer sentByAgentWithId) {
        this.sentByAgentWithId = sentByAgentWithId;
    }

    public boolean isTransferByCash() {
        return transferByCash;
    }

    public void setTransferByCash(boolean transferByCash) {
        this.transferByCash = transferByCash;
    }

    public boolean isNotifyBeneficiary() {
        return notifyBeneficiary;
    }

    public void setNotifyBeneficiary(boolean notifyBeneficiary) {
        this.notifyBeneficiary = notifyBeneficiary;
    }

    public List<Transfert> getTransfers() {
        return transfers;
    }

    public void setTransfers(List<Transfert> transfers) {
        this.transfers = transfers;
    }
}

