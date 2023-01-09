package com.example.ensa_transfert.Models;

import com.example.ensa_transfert.Models.Enumerators.AccountStatus;

public class Account {
    private  Long id;
    private String accountNumber;
    private double balance;
    private Client client;
    private AccountStatus status;

    public Account(Long id, String accountNumber, double balance, Client client, AccountStatus status) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.client = client;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }
}
